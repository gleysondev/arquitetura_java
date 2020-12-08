package aulas.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aulas.model.Role;
import aulas.model.Roles;
import aulas.model.Usuario;
import aulas.repository.RoleRepository;
import aulas.service.UsuarioService;

@Service
public class Inicializacao {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsuarioService service;
	
	public void init() {
		roles();
		admin();
	}
	
	private void roles() {
		Role role = new Role("ADMIN");
		roleRepository.save(role);
		
		role = new Role("USER");
		roleRepository.save(role);
		
		role = new Role("API");
		roleRepository.save(role);
		
	}
	private void admin() {
		
		Usuario admin = new Usuario();
		admin.setLogin("admin");
		admin.addRole(new Role(Roles.ADMIN.name()));;
		admin.setSenha("admin");
		service.saveUsuario(admin);
		
		Usuario api = new Usuario();
		api.setLogin("api");
		api.addRole(new Role(Roles.API.name()));;
		api.setSenha("api");
		service.saveUsuario(api);
		
	}
	
}
