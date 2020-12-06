package aulas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aulas.webapi.init.Inicializacao;

@SpringBootApplication
public class WebApiApplication {// WAR --> extends SpringBootServletInitializer {
	private static final Logger LOGGER = LogManager.getLogger(WebApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(Inicializacao init) {
		return args -> {
			init.configuracaoInicial();
		};
	}
}
