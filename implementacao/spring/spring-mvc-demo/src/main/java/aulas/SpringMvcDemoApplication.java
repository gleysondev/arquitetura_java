package aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcDemoApplication {
	//publicar em servidor de aplicação
	//https://www.baeldung.com/spring-boot-war-tomcat-deploy
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDemoApplication.class, args);
	}

}
