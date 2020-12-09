package aulas.subscriber.action;

import rx.functions.Action1;

public class EnviaEmail implements Action1<String> {
	
	@Override
	public void call(String t) {
		System.out.println("E-mail enviado para " + t);
		
	}

}
