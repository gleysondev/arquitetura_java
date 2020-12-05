package aulas.auth.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aulas.model.Role;
import aulas.model.Roles;
import aulas.model.Usuario;
import aulas.repository.RoleRepository;
import aulas.repository.UsuarioRepository;
import aulas.security.JwtSession;

@RestController
@RequestMapping("/v1/auth/usuarios")
public class UsuarioResource {
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping
	@ResponseBody
	@PreAuthorize(Roles.PRE_ADMIN)
	public List<Usuario> listar() {
		return repository.findAll();
	}
	@PostMapping
	@PreAuthorize(Roles.PRE_ADMIN)
	public void incluir(@RequestBody Usuario usuario) {
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		repository.save(usuario);
	}
	
	@GetMapping(value="/roles")
	public List<Role> listarRoles() {
		System.out.println(JwtSession.getLogin());
		return roleRepository.findAll();
	}
	@PostMapping(value="/roles")
	@PreAuthorize(Roles.PRE_ADMIN)
	public void incluirRole(@RequestBody Role role) {
		roleRepository.save(role);
	}
}
