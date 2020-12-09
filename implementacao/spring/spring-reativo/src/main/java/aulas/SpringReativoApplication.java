package aulas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aulas.start.Init;

@SpringBootApplication
public class SpringReativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReativoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(Init bean) {
		return args -> {
			
			bean.execute();
			
		};
	}

}
