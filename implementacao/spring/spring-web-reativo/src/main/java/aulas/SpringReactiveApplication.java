package aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveApplication {

	public static void main (String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
		System.out.print("hello reactive webflux");
		}

}
