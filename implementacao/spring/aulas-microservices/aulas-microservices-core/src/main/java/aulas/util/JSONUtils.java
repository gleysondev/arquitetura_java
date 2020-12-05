package aulas.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class JSONUtils {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	{
		OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//OBJECT_MAPPER.configure(DeserializationFeature.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	public static String json(Object obj) throws Exception {
		return OBJECT_MAPPER.writeValueAsString(obj);
	}

	public static <T> T convertToObject(String json, Class classe) throws IOException {
		return (T) OBJECT_MAPPER.readValue(json, classe);
	}
	
	public static <T> List<T> convertToList(String json,Class classe) throws IOException{
		List list = OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, classe));
		return list;
	}
	
	
	

}

