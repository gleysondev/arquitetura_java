package aulas;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import aulas.covid.Apuracao;
import aulas.covid.ApuracaoDiaria;
import aulas.covid.actor.Caso;
import aulas.enums.municipio.Estado;
import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.mensageria.MensagemEMAIL;
import aulas.mensageria.MensagemSMS;
import aulas.utils.JsonUtils;

public class Start {
	public static void main(String[] args) {
		//mensageria();
		try {
			gerarJsonApuracao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//apuracao();
	}	
	
	static int numero(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	static void gerarJsonApuracao() throws Exception {
		int  casos = 0;
		int  mortes = 0;
		int  recuperados =0;
		
		List<ApuracaoDiaria> apuracoes ;
		LocalDate data = LocalDate.now();
		
		JsonUtils jsonUtil = new JsonUtils();
		
		for(int x=0; x<10;x++) {
			apuracoes = new ArrayList<ApuracaoDiaria>();
			String jsonName="covid-apuracoes-" + data.toString() + ".json";
			for(Estado e: Estado.values()) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);
				
				apuracoes.add(new ApuracaoDiaria(e.getSigla(), casos, mortes, recuperados));
			}
			//convertendo em String a resposta
			String reposta = jsonUtil.toString(apuracoes);
			//salvando em disco o json
			jsonUtil.toFile(apuracoes,new File(jsonUtil.storage(), jsonName));
			data=data.plusDays(1);
		}
		
		System.out.println("FIM");
		
	}
	
	static void apuracao() {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("COVIDApuracaoSystem");

		// Criando o ator
		Apuracao ac = new Apuracao();
		ac.setEstado("AC");
		ActorRef actor  = system.actorOf(Props.create(Caso.class), ac.getEstado());
		actor.tell(ac, ActorRef.noSender());
	}
	
	static void mensageria() {
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("MensageriaSystem");

		// Criando o ator
		ActorRef email  = system.actorOf(Props.create(MensagemEMAIL.class), "email");
		ActorRef sms  = system.actorOf(Props.create(MensagemSMS.class), "sms");
		
		List<Municipio> lista = Estados.municipios(Estado.ACRE.getId());
		for(Municipio m: lista) {
			String msg=String.format("Caro Municipio - %s (%s) - FAVOR enviar os dados de pesquisa do Covid ", m.getNome(), m.getSigla());
			email.tell(msg, ActorRef.noSender());
			sms.tell(msg, ActorRef.noSender());
		}
	}
}
