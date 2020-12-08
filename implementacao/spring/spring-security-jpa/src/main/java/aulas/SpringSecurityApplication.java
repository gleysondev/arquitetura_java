package aulas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aulas.init.Inicializacao;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	// https://developer.okta.com/blog/2018/10/31/jwts-with-java
	@Bean
	public CommandLineRunner run(Inicializacao init) {
		return args -> {
			init.init();
		};
	}

}
