package aulas.observables;

import org.springframework.stereotype.Component;

import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.subscriber.EnviaUrnaEletronicaSubscriber;
import rx.Observable;
@Component
public class TodosEstadosObservable{
	public void enviar() {
		Observable<Municipio> observable = Observable.from(Estados.CIDADES);
		observable.subscribe(new EnviaUrnaEletronicaSubscriber());
	}
}
