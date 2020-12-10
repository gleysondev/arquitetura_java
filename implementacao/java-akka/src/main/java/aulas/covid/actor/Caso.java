package aulas.covid.actor;

import akka.actor.UntypedActor;
import aulas.covid.Apuracao;

//Tentar aplicar generics
public class Caso extends UntypedActor{

	//Tentar aplicar generics
	@Override
	public void onReceive(Object arg0) throws Exception {
		Apuracao a  =(Apuracao) arg0;
		
		
	}

}
