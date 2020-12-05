package aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AulasMicroservicesCadastrosApplication {
	public static void main(String[] args) {
		//sem barramento: http://localhost:8083/swagger-ui.html
		//com barramento: http://localhost:8080/gateway/aulas-cadastros/swagger-ui.html
		SpringApplication.run(AulasMicroservicesCadastrosApplication.class, args);
	}
}
