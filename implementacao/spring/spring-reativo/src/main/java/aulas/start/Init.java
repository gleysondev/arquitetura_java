package aulas.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aulas.observables.TodosEstadosObservable;

@Component
public class Init {
	@Autowired
	private TodosEstadosObservable teo;
	public void execute() {
		teo.enviar();
	}
}
