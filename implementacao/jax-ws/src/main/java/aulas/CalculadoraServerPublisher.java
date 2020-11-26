package aulas;

import javax.xml.ws.Endpoint;

public class CalculadoraServerPublisher {
	public static void main(String[] args)
	  {
	    Endpoint.publish("http://127.0.0.1:8181/calc",
	    new CalculadoraServerImpl());
	  }
}
