package aulas.subscriber;

import aulas.enums.municipio.Paises;
import rx.Subscriber;

public class CopaMundoSubscriber extends Subscriber<Paises> {

	@Override
	public void onCompleted() {
		System.out.println("Iniciar a venda de ingressos");
		
	}

	@Override
	public void onError(Throwable e) {
		System.out.println("Copa do Mundo Erro " + e.getMessage());
		
	}

	@Override
	public void onNext(Paises e) {
		System.out.println("Estadios Construidos " + e.getNome());
		
		
	}

	
	
}
