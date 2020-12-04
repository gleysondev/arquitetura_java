package aulas.componente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import aulas.config.EmailConfig;

@Component
public class Mensagem {
	
	@Autowired
	private EmailConfig config;
	
	@Value("${emissor}")
	private String emissor;
	
	@Value("${estados}")
	private List<String> estados;
	
	public void enviar(String mensagem) {
	
		System.out.println(estados);
		
		System.out.println(emissor);
		
		System.out.println(config);
		
		System.out.println(mensagem);
	}
	public Mensagem() {
		System.out.println("Criando um novo objeto Mensagem");
	}
	public Mensagem(String tipo) {
		System.out.println("Criando um novo objeto Mensagem do tipo " + tipo);
	}
}
