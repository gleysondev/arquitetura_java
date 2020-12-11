package aulas;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import aulas.covid.Apuracao;
import aulas.covid.ApuracaoDiaria;
import aulas.covid.actor.ApuracaoDiariaActor;
import aulas.enums.municipio.Estado;
import aulas.utils.FileStorage;
import aulas.utils.JsonUtils;

public class Start2 {
	public static void main(String[] args) {
		try {
			atualizarApuracaoGlobal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void atualizarApuracaoGlobal() throws Exception {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("COVIDApuracaoSystem");

		// Com base em um conjunto de dados iniciar os nossos atores
		// Criando o ator
		// Aqui é tua entidade

		List<ApuracaoDiaria> loteApuracoes = apuracoesDiarias();

		List<Apuracao> apuracoesSereliazadas = null;
		
		
		for (Estado e : Estado.values()) {
			//esta apuração pode ser armanezada em base de dados e depois consultado trazendo os dados atuais
			Apuracao apuracao = new Apuracao(); // Apuracoes: MA, PI, SP, AC
			apuracao.setEstado(e.getSigla());
			
			apuracao.setApuracoes(filtrarApuracaoEstado(e.getSigla(), loteApuracoes));
			
			//--> apuracoesSereliazadas.add(apuracao);
			
			// AQUI DE FATO ESTAMOS APLICANDO - PROGRAMAÇÃO CONCORRENTE
			// Criandos nossos atores no System Poll
			ActorRef actor = system.actorOf(Props.create(ApuracaoDiariaActor.class), apuracao.getEstado());
			
			actor.tell(apuracao, ActorRef.noSender());
		}
		
		for(Apuracao apuracao: apuracoesSereliazadas) {
			// Criandos nossos atores no System Poll
			ActorRef actor = system.actorOf(Props.create(ApuracaoDiariaActor.class), apuracao.getEstado());
			
			actor.tell(apuracao, ActorRef.noSender());
		}

	}
	
	static List<Apuracao> obeterApuracoesJaExistentes(){
		//obter no reposiorio de apuracoes Serelializadas
		return null;
	}
	
	
	static List<ApuracaoDiaria> filtrarApuracaoEstado(String uf, List<ApuracaoDiaria> loteApuracoes) {
		Predicate<ApuracaoDiaria> ufId = m -> m.getEstado().equals(uf);
		Stream<ApuracaoDiaria> stream = loteApuracoes.stream();
		stream = stream.filter(ufId);
		List<ApuracaoDiaria>  apuracoes = stream.collect(Collectors.toList());
		return apuracoes;
	}
	
	
	static List<ApuracaoDiaria> apuracoesDiarias() throws Exception {
		JsonUtils jsonUtil = new JsonUtils();

		List<ApuracaoDiaria> apuracoesGeral = new ArrayList<ApuracaoDiaria>();
		File dir = FileStorage.storage();
		for (String j : dir.list()) {
			String json = new String(Files.readAllBytes(Paths.get(dir.getAbsolutePath(), j)));
			List<ApuracaoDiaria> apuracoes = jsonUtil.getMapper().readValue(json,
					new TypeReference<List<ApuracaoDiaria>>() {
					});
			apuracoesGeral.addAll(apuracoes);

		}

		return apuracoesGeral;
	}
	
}
