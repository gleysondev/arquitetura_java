package aulas.load;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aulas.enums.municipio.Estado;
import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;
import aulas.model.CidadeApuracaoDiaria;
import aulas.model.UfApuracaoDiaria;
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
			//gerarJsonApuracaoEstado();
			//gerarJsonApuracaoMunicipioPorDia();
			gerarJsonApuracaoMunicipioGeral();
		}else {
			System.out.println("DIRETORIO COM JSON");
		}
		
	}
	static int numero(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	static void gerarJsonApuracaoMunicipioGeral() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;
		
		int dias=365;

		List<CidadeApuracaoDiaria> apuracoes;
		LocalDate data = LocalDate.of(2020, 1, 1);

		JsonUtils jsonUtil = new JsonUtils();
		String jsonName = "covid-apuracoes-municipais.json";
		
		for (int x = 0; x < dias; x++) {
			apuracoes = new ArrayList<CidadeApuracaoDiaria>();
			for (Municipio e : Estados.CIDADES) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new CidadeApuracaoDiaria( data.toString(), e.getId(),e.getUf(), casos, mortes, recuperados));
			}
			// convertendo em String a resposta
			String reposta = jsonUtil.toString(apuracoes);
			// salvando em disco o json
			jsonUtil.toFile(apuracoes, new File(FileStorage.storage(), jsonName));
			data = data.plusDays(1);
			System.out.println("Processando dia " + data.toString());
		}

		System.out.println("FIM gerarJsonApuracaoMunicipioGeral");

	}
	
	static void gerarJsonApuracaoMunicipioPorDia() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;
		
		int dias=30;

		List<CidadeApuracaoDiaria> apuracoes;
		LocalDate data = LocalDate.now();

		JsonUtils jsonUtil = new JsonUtils();

		for (int x = 0; x < dias; x++) {
			apuracoes = new ArrayList<CidadeApuracaoDiaria>();
			String jsonName = "covid-apuracoes-" + data.toString() + ".json";
			for (Municipio e : Estados.CIDADES) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new CidadeApuracaoDiaria( data.toString(), e.getId(),e.getUf(), casos, mortes, recuperados));
			}
			// convertendo em String a resposta
			String reposta = jsonUtil.toString(apuracoes);
			// salvando em disco o json
			jsonUtil.toFile(apuracoes, new File(FileStorage.storage(), jsonName));
			data = data.plusDays(1);
		}

		System.out.println("FIM gerarJsonApuracaoMunicipioPorDia");

	}
	
	static void gerarJsonApuracaoEstado() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;
		
		int dias=10;

		List<UfApuracaoDiaria> apuracoes;
		LocalDate data = LocalDate.now();

		JsonUtils jsonUtil = new JsonUtils();

		for (int x = 0; x < dias; x++) {
			apuracoes = new ArrayList<UfApuracaoDiaria>();
			String jsonName = "covid-apuracoes-" + data.toString() + ".json";
			for (Estado e : Estado.values()) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new UfApuracaoDiaria(e.getSigla(), casos, mortes, recuperados, data.toString()));
			}
			// convertendo em String a resposta
			String reposta = jsonUtil.toString(apuracoes);
			// salvando em disco o json
			jsonUtil.toFile(apuracoes, new File(FileStorage.storage(), jsonName));
			data = data.plusDays(1);
		}

		System.out.println("FIM");

	}

}
