package aulas;

import java.io.IOException;

import javax.xml.ws.Endpoint;

import aulas.resource.OficialResource;

public class JaxWsApplication {
	public static final String BASE_URI = "http://localhost:8181";
	public static void main(String[] args)
	  {
		
        try {
        	System.out.println(String.format("Jax-WS Start %s/oficiais?wsdl \nHit enter to stop it...", BASE_URI));
        	Endpoint.publish(BASE_URI + "/oficiais", new OficialResource());
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	  }
}
