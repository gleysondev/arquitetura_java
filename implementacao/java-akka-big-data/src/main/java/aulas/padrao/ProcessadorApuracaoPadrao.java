package aulas.padrao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import aulas.model.ApuracaoEstado;
import aulas.model.diaria.ApuracaoDiaria;
import aulas.utils.FileStorage;
import aulas.utils.JsonUtils;

public class ProcessadorApuracaoPadrao {
	private  static SimpleDateFormat df;
	private static Map<Integer, ApuracaoEstado> estados = new HashMap<Integer, ApuracaoEstado>();
	public static void main(String[] args) {
		try {
			df= new SimpleDateFormat("HH:mm:ss.SSS");
			
			List<ApuracaoDiaria> apuracoes = getApuracoesFile();
			
			log("INICIANDO O PROCESSO");
			
			
			log("FIM  DO PROCESSO");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static void log(String mensagem) {
		System.out.println(df.format(new Date()) + " --> " + mensagem);
	}
	public static ApuracaoEstado getApuracao(Integer uf) {
		ApuracaoEstado item = estados.get(uf);
		if(item==null) {
			item = new ApuracaoEstado();
			estados.put(uf, item);
		}
		return item;
	}
	private static List<ApuracaoDiaria> getApuracoesFile() throws Exception{
		JsonUtils jsonUtil = new JsonUtils();
		
		File file = new File(FileStorage.storage(),"covid-apuracoes-municipais.json");
		
		String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		List<ApuracaoDiaria> apuracoes = jsonUtil.getMapper().readValue(json,new TypeReference<List<ApuracaoDiaria>>() {});
		
		return apuracoes;
	}
	
}
