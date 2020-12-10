package aulas.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {
	private ObjectMapper mapper;
	public JsonUtils() {
		mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}
	public <T> List<T>  toList(String json,Class<T> tipo) throws Exception{
		List<T> list = (List<T>) mapper.readValue(json, tipo);
		return list;
	}
	
	public ObjectMapper getMapper() {
		return mapper;
	}
	
	public String toString(Object object) throws Exception {
		String json = mapper.writeValueAsString(object);
		return json;
	}
	public  File toFile(Object object, File file) throws Exception {
		String json = toString(object);
		try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath())) {
		    fileWriter.write(json);
		}
		return file;
	}
	public File storage() {
		File diretorio =new File("/temp/storage");
		if(!diretorio.exists())
			diretorio.mkdirs();
		return diretorio;
	}
}
