package aulas.covid.actor;

import java.util.List;

import akka.actor.UntypedActor;
import aulas.covid.Apuracao;
import aulas.covid.ApuracaoDiaria;
import aulas.enums.municipio.Estado;

//Tentar aplicar generics
public class ApuracaoDiariaActor extends UntypedActor{

	//Tentar aplicar generics
	@Override
	public void onReceive(Object arg0) throws Exception {
		Apuracao a  =(Apuracao) arg0;
		
		List<ApuracaoDiaria> apuracoes = a.getApuracoes();
		for(ApuracaoDiaria ad: apuracoes) {
			if(a.getEstado().equals(Estado.MARANHAO.getSigla())) {
				System.out.println(String.format("%s Casos %d - Novos Casos %d ", a.getEstado(), a.getCasos(),ad.getCasos()));
				
			}
			a.apurarCasos(ad.getCasos());
			a.apurarMortes(ad.getMortes());
			a.apurarRecuperados(ad.getRecuperados());
			
			
		}
		System.out.println(a);
		/*
		if(a.getEstado().equals(Estado.SAO_PAULO.getSigla())) {
			System.out.println(a);
		}
		else {
			System.out.println(a.getEstado());
		}
		*/
	}

}
