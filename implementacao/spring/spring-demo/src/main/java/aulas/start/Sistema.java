package aulas.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aulas.componente.Mensagem;
import aulas.oficial.Oficial;

@Component
public class Sistema {
	
	@Autowired
	private Mensagem mensgem;
	
	public void inicializar() {
		Oficial oficial = new Oficial();
		oficial.setNome("Jose");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
		
		oficial = new Oficial();
		oficial.setNome("Marcos");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
	}
	
}
