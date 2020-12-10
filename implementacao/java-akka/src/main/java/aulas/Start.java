package aulas;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import aulas.actor.EcoActor;

public class Start {
	public static void main(String[] args) {
		//De envio das urnas eletronicas por estado
		
		// Criação de um Actor System, container Akka.
		ActorSystem system = ActorSystem.create("HelloSystem");

		// Criando o ator EcoActor
		ActorRef ecoActor  = system.actorOf(Props.create(EcoActor.class), "eco");

		// Enviando a mensagem ao ator
		ecoActor.tell("Alô Mundo com Atores", ActorRef.noSender());
	}
}
