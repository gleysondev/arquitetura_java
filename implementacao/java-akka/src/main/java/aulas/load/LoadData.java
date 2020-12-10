package aulas.load;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aulas.covid.ApuracaoDiaria;
import aulas.enums.municipio.Estado;
import aulas.utils.FileStorage;
import aulas.utils.JsonUtils;

public class LoadData {
	public static void execute() throws Exception {
		if(!FileStorage.storage().exists() || FileStorage.storage().list().length ==0 ) {
			gerarJsonApuracao();
		}else {
			System.out.println("DIRETORIO COM JSON");
		}
		
	}
	static int numero(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	static void gerarJsonApuracao() throws Exception {
		int casos = 0;
		int mortes = 0;
		int recuperados = 0;

		List<ApuracaoDiaria> apuracoes;
		LocalDate data = LocalDate.now();

		JsonUtils jsonUtil = new JsonUtils();

		for (int x = 0; x < 10; x++) {
			apuracoes = new ArrayList<ApuracaoDiaria>();
			String jsonName = "covid-apuracoes-" + data.toString() + ".json";
			for (Estado e : Estado.values()) {
				casos = numero(10, 100);
				mortes = numero(1, 10);
				recuperados = numero(1, 30);

				apuracoes.add(new ApuracaoDiaria(e.getSigla(), casos, mortes, recuperados, data.toString()));
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
