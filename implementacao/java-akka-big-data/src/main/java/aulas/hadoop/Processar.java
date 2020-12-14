package aulas.hadoop;

import org.apache.hadoop.util.ToolRunner;

//https://www.youtube.com/watch?v=FI5hWp6Hybg
public class Processar {
	public static void main(String[] args) {
		try {
			//https://stackoverflow.com/questions/17550242/priviledgedactionexception-failed-to-set-permissions-of-path
			String[]files = {"covid-apuracoes-municipais.txt", "covid-apuracoes-municipais-resumo.txt"}; 
			int exitCode = ToolRunner.run(new CovidApuracao(), files );
			System.exit(exitCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
	
	
}
