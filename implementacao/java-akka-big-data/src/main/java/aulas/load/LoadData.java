package aulas.load;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.model.diaria.ApuracaoDiaria;
import aulas.utils.FileStorage;
import aulas.utils.JsonUtils;

public class LoadData {
	public static void main(String[] args) {
		try {
			execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void execute() throws Exception {
		if(!FileStorage.storage().exists() || FileStorage.storage().list().length ==0 ) {
			//gerarJsonApuracaoMunicipioPorDia();
			gerarApuracaoMunicipioGeral();
			
			//JSON
			
		}else {
			System.out.println("DIRETORIO COM JSON");
		}
		
	}
	static int numero(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	static void gerarApuracaoMunicipioGeral() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;
		
		List<ApuracaoDiaria> apuracoes = new ArrayList<ApuracaoDiaria>();
		LocalDate data = LocalDate.of(2020, 1, 1);
		
		int cids = 0;//5566
		int dias = 2;
		for (int x = 0; x < dias; x++) {
			for (Municipio e : Estados.CIDADES) {
				casos = numero(10, 50);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new ApuracaoDiaria( data.toString(), e.getId(),e.getUf(), casos, mortes, recuperados));
				cids++;
				if(cids==3) {
					cids=0;
					break;
				}
			}
			
			System.out.println("Processando dia " + data.toString());
			data = data.plusDays(1);
		}
		System.out.println("FIM gerarJsonApuracaoMunicipioGeral");
		
		gerarJson(apuracoes);
		gerarCsv(apuracoes);
		gerarTxt(apuracoes);

	}
	private static void gerarTxt(List<ApuracaoDiaria> apuracoes) throws Exception{
		String jsonName = "covid-apuracoes-municipais.txt";
		StringBuilder sb = new StringBuilder();
		for(ApuracaoDiaria ad: apuracoes) {
			sb.append(String.format("E%dM%dC%d ", ad.getUf(),ad.getIbge(),1));
			sb.append(String.format("E%dM%dM%d ", ad.getUf(),ad.getIbge(),1));
			sb.append(String.format("E%dM%dR%d\n", ad.getUf(),ad.getIbge(),1));
		}
		try (FileWriter fileWriter = new FileWriter(new File(FileStorage.storage(), jsonName))) {
		    fileWriter.write(sb.toString());
		}
		
		System.out.println("FIM gerarJsonApuracao  TXT");
	}
	private static void gerarCsv(List<ApuracaoDiaria> apuracoes) throws Exception{
		String jsonName = "covid-apuracoes-municipais.csv";
		StringBuilder sb = new StringBuilder();
		for(ApuracaoDiaria ad: apuracoes) {
			sb.append(String.format("%s;%d;%d;%d;%d;%d\n", ad.getData(),ad.getUf(),ad.getIbge(),ad.getCasos(),ad.getMortes(),ad.getRecuperados()));
		}
		try (FileWriter fileWriter = new FileWriter(new File(FileStorage.storage(), jsonName))) {
		    fileWriter.write(sb.toString());
		}
		
		System.out.println("FIM gerarJsonApuracao  CSV");
	}
	private static void gerarJson(List<ApuracaoDiaria> apuracoes) throws Exception{
		JsonUtils jsonUtil = new JsonUtils();
		String jsonName = "covid-apuracoes-municipais.json";
		// convertendo em String a resposta
		String reposta = jsonUtil.toString(apuracoes);
		// salvando em disco o json
		jsonUtil.toFile(apuracoes, new File(FileStorage.storage(), jsonName));
		
		
		System.out.println("FIM gerarJsonApuracao  JSON");
	}
	
	static void gerarJsonApuracaoMunicipioPorDia() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;
		
		int dias=30;

		List<ApuracaoDiaria> apuracoes;
		LocalDate data = LocalDate.now();

		JsonUtils jsonUtil = new JsonUtils();

		for (int x = 0; x < dias; x++) {
			apuracoes = new ArrayList<ApuracaoDiaria>();
			String jsonName = "covid-apuracoes-" + data.toString() + ".json";
			for (Municipio e : Estados.CIDADES) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new ApuracaoDiaria( data.toString(), e.getId(),e.getUf(), casos, mortes, recuperados));
			}
			// convertendo em String a resposta
			String reposta = jsonUtil.toString(apuracoes);
			// salvando em disco o json
			jsonUtil.toFile(apuracoes, new File(FileStorage.storage(), jsonName));
			data = data.plusDays(1);
		}

		System.out.println("FIM gerarJsonApuracaoMunicipioPorDia");

	}
}
