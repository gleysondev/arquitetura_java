package aulas.webapi.resource;

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

import aulas.webapi.model.Roles;
import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsuarioRepository repository;
	@GetMapping
	@ResponseBody
	@PreAuthorize(Roles.USUARIOS_SEARCH)
	public List<Usuario> listar() {
		return repository.findAll();
	}
	@PostMapping
	public void incluir(@RequestBody Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		repository.save(usuario);
	}
	
}
