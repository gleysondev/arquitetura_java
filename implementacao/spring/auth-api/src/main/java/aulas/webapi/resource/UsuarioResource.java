package aulas.webapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.webapi.model.Roles;
import aulas.webapi.model.acesso.Role;
import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.RoleRepository;
import aulas.webapi.repository.UsuarioRepository;
import aulas.webapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;

	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/roles")
	//@PreAuthorize(Roles.PRE_USER)
	private List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	@GetMapping
	@PreAuthorize(Roles.PRE_ADMIN)
	public List<Usuario> listar() {
		return repository.findAll();
	}
		
	@PostMapping
	public void incluir(@RequestBody Usuario usuario) {
		service.saveUsuario(usuario);
	}
	
}
