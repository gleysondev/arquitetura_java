package aulas.observables;

import org.springframework.stereotype.Component;

import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.enums.municipio.Paises;
import aulas.subscriber.CopaMundoSubscriber;
import aulas.subscriber.EnviaUrnaEletronicaSubscriber;
import aulas.subscriber.action.EnviaEmail;
import aulas.subscriber.action.Impressao;
import rx.Observable;
@Component
public class EstadoObservable{
	public void from() {
		Observable<Municipio> observable = Observable.from(Estados.CIDADES);
		observable.subscribe(new EnviaUrnaEletronicaSubscriber());	
	}
	
	public void just(Paises paisCopaMundo) {
		Observable<Paises> observable = Observable.just(paisCopaMundo);
		observable.subscribe(new CopaMundoSubscriber());
	}
	
	public void action(String email) {
		Observable<String> observable = Observable.just(email);
		observable.subscribe(new EnviaEmail());
	}
	public void repeat(String email, int paginas) {
		Observable.just(email)
		  .repeat(paginas)
		  .subscribe(new Impressao());
	}
}
