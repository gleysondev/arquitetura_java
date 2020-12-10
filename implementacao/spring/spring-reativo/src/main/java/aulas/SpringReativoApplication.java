package aulas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aulas.start.Init;

@SpringBootApplication
public class SpringReativoApplication {
	//https://medium.com/better-programming/rxjava-different-ways-of-creating-observables-7ec3204f1e23
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
