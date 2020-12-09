package aulas.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aulas.enums.municipio.Paises;
import aulas.observables.EstadoObservable;

@Component
public class Init {
	@Autowired
	private EstadoObservable teo;
	public void execute() {
		System.out.println("*****FROM****");
		teo.from();
		
		System.out.println("*****JUST****");
		teo.just(Paises.BR);
		
		System.out.println("*****ACTION****");
		teo.action("email@email.com");
		
		System.out.println("*****REPEAT****");
		teo.repeat("CARDÁPIO",10);
	}
}
