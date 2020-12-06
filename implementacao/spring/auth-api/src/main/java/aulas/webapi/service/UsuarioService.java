package aulas.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aulas.webapi.model.Roles;
import aulas.webapi.model.acesso.Role;
import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
		
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	public Integer saveUsuario(Usuario usuario) {
	
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(usuario.getRoles()==null || usuario.getRoles().size() ==0) {
			usuario.addRole(new Role(Roles.USER.name()));;
		}
		
		if(!userRepository.existsByLogin(usuario.getLogin())) {
			usuario = userRepository.save(usuario);
			return usuario.getId();
		}
		return null;
	}
	
	
	
}
