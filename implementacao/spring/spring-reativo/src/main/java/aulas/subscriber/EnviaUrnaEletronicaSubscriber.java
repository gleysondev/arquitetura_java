package aulas.subscriber;

import aulas.enums.municipio.Municipio;
import rx.Subscriber;

public class EnviaUrnaEletronicaSubscriber extends Subscriber<Municipio> {

	@Override
	public void onCompleted() {
		System.out.println("Processo de entrega de urnas finalizado");
		
	}

	@Override
	public void onError(Throwable e) {
		System.out.println("TRE - Informamos que não foi localizada a prefeittura " + e.getMessage());
		
	}

	@Override
	public void onNext(Municipio e) {
		System.out.println("Enviando urna para " + e.getNome() + "(" + e.getSigla() + ")");
		if(e.getNome().equals("VICOSA")) {
			//throw new RuntimeException("PREFEITURA NÃO LOCALIZADA -- > " + e.getNome() + "(" + e.getSigla() + ")" );
		}
		
	}

	
	
}
