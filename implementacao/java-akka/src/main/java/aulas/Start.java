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
import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.load.LoadData;
import aulas.mensageria.MensagemEMAIL;
import aulas.mensageria.MensagemSMS;
import aulas.utils.FileStorage;
import aulas.utils.JsonUtils;

public class Start {
	public static void main(String[] args) {
		// mensageria();
		try {
			LoadData.execute();
			atualizarApuracaoGlobal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// apuracao();
	}
	static void atualizarApuracaoGlobal() throws Exception {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("COVIDApuracaoSystem");

		// Com base em um conjunto de dados iniciar os nossos atores
		// Criando o ator
		// Aqui é tua entidade

		List<ApuracaoDiaria> loteApuracoes = processarAquivosApuracao();

		// AQUI DE FATO ESTAMOS APLICANDO - PROGRAMAÇÃO CONCORRENTE

		// Criandos nossos atores no System Poll

		for (Estado e : Estado.values()) {
			//esta apuração pode ser armanezada em base de dados e depois consultado trazendo os dados atuais
			Apuracao apuracao = new Apuracao();
			apuracao.setEstado(e.getSigla());
			
			
			apuracao.setApuracoes(filtrarApuracaoEstado(e.getSigla(), loteApuracoes));
			
			ActorRef actor = system.actorOf(Props.create(ApuracaoDiariaActor.class), apuracao.getEstado());
			actor.tell(apuracao, ActorRef.noSender());
		}
		
		


	}
	static List<ApuracaoDiaria> filtrarApuracaoEstado(String uf, List<ApuracaoDiaria> loteApuracoes) {
		
		Predicate<ApuracaoDiaria> ufId = m -> m.getEstado().equals(uf);
		
		Stream<ApuracaoDiaria> stream = loteApuracoes.stream();
		stream = stream.filter(ufId);
		
		List<ApuracaoDiaria>  apuracoes = stream.collect(Collectors.toList());
		
		return apuracoes;
	}
	
	static List<ApuracaoDiaria> processarAquivosApuracao() throws Exception {
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
	
	static void apuracaoDemo() {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("COVIDApuracaoSystem");

		// Criando o ator
		Apuracao ac = new Apuracao();
		ac.setEstado("AC");
		ActorRef actor = system.actorOf(Props.create(ApuracaoDiariaActor.class), ac.getEstado());
		actor.tell(ac, ActorRef.noSender());
	}

	static void mensageria() {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("MensageriaSystem");

		// Criando o ator
		ActorRef email = system.actorOf(Props.create(MensagemEMAIL.class), "email");
		ActorRef sms = system.actorOf(Props.create(MensagemSMS.class), "sms");

		List<Municipio> lista = Estados.municipios(Estado.ACRE.getId());
		for (Municipio m : lista) {
			String msg = String.format("Caro Municipio - %s (%s) - FAVOR enviar os dados de pesquisa do Covid ",
					m.getNome(), m.getSigla());
			email.tell(msg, ActorRef.noSender());
			sms.tell(msg, ActorRef.noSender());
		}
	}
}
