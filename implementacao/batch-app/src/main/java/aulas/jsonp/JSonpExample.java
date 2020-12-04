package aulas.jsonp;

import java.io.StringReader;
import java.math.BigDecimal;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
//https://javaee.github.io/jsonp/getting-started.html
public class JSonpExample {
	public static void main(String[] args) {
		sample();
	}
	public static void sample() {
		// Create Json and serialize
		
		System.out.println("GERAR JSON");
		JsonObject json = Json.createObjectBuilder().add("name", "Falco").add("age", BigDecimal.valueOf(3))
				.add("biteable", Boolean.FALSE).build();
		String result = json.toString();

		System.out.println(result);
		
		
		System.out.println("LER ATRIBUTO TEXTO");
		
	    result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":false}";
	    final JsonParser parser = Json.createParser(new StringReader(result));
	    String key = null;
	    String value = null;
	    while (parser.hasNext()) {
	        final Event event = parser.next();
	        switch (event) {
	        case KEY_NAME:
	            key = parser.getString();
	            System.out.println(key);
	            break;
	        case VALUE_STRING:
	            value = parser.getString();
	            System.out.println(value);
	            break;
	        }
	    }
	    parser.close();
	    
	    System.out.println("LER ATRIBUTO");
		
	    JsonReader jsonReader = Json.createReader(new StringReader("{\"name\":\"Falco\",\"age\":3,\"bitable\":false}"));
	    JsonObject jobj = jsonReader.readObject();        
	    System.out.println(jobj);
	}
}
