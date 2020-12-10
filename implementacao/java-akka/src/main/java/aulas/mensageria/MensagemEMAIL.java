package aulas.mensageria;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MensagemEMAIL extends UntypedActor {

	  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	  @Override
	  public void onReceive(Object msg) throws Exception {
	    log.info("EMAIL :: " + msg);
	  }

}
