package aulas.webapi.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aulas.webapi.model.Roles;
import aulas.webapi.model.acesso.Role;
import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.RoleRepository;
import aulas.webapi.service.UsuarioService;

@Service
public class Inicializacao {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsuarioService service;
	
	public void init() {
		roles();
		operadorAdmin();
	}
	
	private void roles() {
		Role role = new Role("ADMIN");
		roleRepository.save(role);
		
		role = new Role("USER");
		roleRepository.save(role);
		
	}
	private void operadorAdmin() {
		
		Usuario admin = new Usuario();
		admin.setLogin("admin");
		admin.addRole(new Role(Roles.ADMIN.name()));;
		admin.setSenha("admin");
		service.saveUsuario(admin);
		
	}
	
}
