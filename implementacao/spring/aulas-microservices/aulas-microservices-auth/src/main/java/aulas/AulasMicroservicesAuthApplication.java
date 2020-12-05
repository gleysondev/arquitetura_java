package aulas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import aulas.model.Role;
import aulas.model.Roles;
import aulas.model.Usuario;
import aulas.repository.RoleRepository;
import aulas.repository.UsuarioRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AulasMicroservicesAuthApplication {
	private static final Logger LOGGER = LogManager.getLogger(AulasMicroservicesAuthApplication.class);
	public static void main(String[] args) {
		//sem barramento: http://localhost:8082/swagger-ui.html
		//com barramento: http://localhost:8080/gateway/aulas-auth/swagger-ui.html
		SpringApplication.run(AulasMicroservicesAuthApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(UsuarioRepository repository,RoleRepository roleRepository,PasswordEncoder encoder) {
		return args -> {
			if(repository.findByUsername("admin")==null) {
				Role r = new Role(Roles.ADMIN.name());
				roleRepository.save(r);
				LOGGER.info("Criando a Role ADMIN ");
				Usuario user = new Usuario();
				user.setUsername("admin");
				String senha = encoder.encode("admin");
				user.setPassword(senha);
				user.setNome("ADMINISTRADOR");
				user.setEmail("admin@aulas.com.br");
				user.addRole(r);
				repository.save(user);
				LOGGER.info("Criando o Usuário ADMIN ");
			};
			if(repository.findByUsername("api")==null) {
				Role r = new Role(Roles.API.name());
				roleRepository.save(r);
				LOGGER.info("Criando a Role API ");
				Usuario user = new Usuario();
				user.setUsername("api");
				String senha = encoder.encode("api");
				user.setPassword(senha);
				user.setNome("CLIENT APIS AULAS");
				user.setEmail("api@aulas.com.br");
				user.addRole(r);
				repository.save(user);
				LOGGER.info("Criando o Usuário API ");
			};
			
			
		};
	}
}
