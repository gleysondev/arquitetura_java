package aulas;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aulas.componente.Mensagem;
import aulas.config.AppConfig;
import aulas.oficial.Oficial;
import aulas.start.Sistema;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Bean
    public CommandLineRunner run(Sistema bean) {
        return args -> {
        	bean.inicializar();
        };
    }
	
	/*
	public static void main(String[] args) {
		//springComXml();
		springComAnotacao();
	}
	*/
	
	private static void springComAnotacao() {
		System.out.println("Iniciando o Spring com Anotação");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
	    
		Mensagem mensgem = (Mensagem) ctx.getBean(Mensagem.class);
		Oficial oficial = new Oficial();
		oficial.setNome("Jose");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
		
		mensgem = ctx.getBean("mensagem",Mensagem.class);
		oficial = new Oficial();
		oficial.setNome("Marcos");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
	}
	
	private static void springComXml() {
		System.out.println("Iniciando o Spring com Xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "beans.xml" );
	    
		Mensagem mensgem = ctx.getBean("mensagem",Mensagem.class);
		Oficial oficial = new Oficial();
		oficial.setNome("Jose");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
		
		mensgem = ctx.getBean("mensagem",Mensagem.class);
		oficial = new Oficial();
		oficial.setNome("Marcos");
		mensgem.enviar(String.format("Bem-vindo %s", oficial.getNome() ));
	}
}
