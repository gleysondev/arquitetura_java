package aulas.padrao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

import aulas.model.ApuracaoEstado;
import aulas.model.ApuracaoMunicipio;
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
			System.out.println("Numero de apuracoes " + apuracoes.size());
			log("INICIANDO O PROCESSO");
			
			for(ApuracaoDiaria ad: apuracoes) {
				getApuracao(ad);
			}
			
			System.out.println(estados.size());
			
			
			for (Map.Entry<Integer, ApuracaoEstado> estado : estados.entrySet()) {
				ApuracaoEstado resumo = estado.getValue();
				log("INICIANDO A APURACAO DO ESTADO --> " +  resumo.getUf());
				for (Map.Entry<Integer, ApuracaoMunicipio> entry : resumo.getMunicipios().entrySet()) {
			          log("IBGE : " + entry.getKey() + ", RESULTADO : " + entry.getValue());
			    }
				System.out.println("-----------------------------------------------------------------------");
		    }
			
			
			
			log("FIM  DO PROCESSO");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static void log(String mensagem) {
		System.out.println(df.format(new Date()) + " --> " + mensagem);
	}
	public static ApuracaoEstado getApuracao(ApuracaoDiaria apuracao) {
		Integer uf = apuracao.getUf();
		ApuracaoEstado item = estados.get(uf);
		if(item==null) {
			item = new ApuracaoEstado();
			item.setUf(uf);
			estados.put(uf, item);
		}
		item.apurarCasos(apuracao.getCasos());
		item.apurarMortes(apuracao.getMortes());
		item.apurarRecuperados(apuracao.getRecuperados());
		
		apuracaoMunicipio(item, apuracao);
		return item;
	}
	public static void apuracaoMunicipio(ApuracaoEstado estado, ApuracaoDiaria apuracao ) {
		Integer ibge = apuracao.getIbge();
		ApuracaoMunicipio item = estado.getApuracaoMunicipio(ibge);
		
		item.setIbge(ibge);
		item.apurarCasos(apuracao.getCasos());
		item.apurarMortes(apuracao.getMortes());
		item.apurarRecuperados(apuracao.getRecuperados());
		
		
	}
	private static List<ApuracaoDiaria> getApuracoesFile() throws Exception{
		JsonUtils jsonUtil = new JsonUtils();
		
		File file = new File(FileStorage.storage(),"covid-apuracoes-municipais.json");
		
		String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		List<ApuracaoDiaria> apuracoes = jsonUtil.getMapper().readValue(json,new TypeReference<List<ApuracaoDiaria>>() {});
		
		return apuracoes;
	}
	
}
