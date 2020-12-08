package aulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import aulas.model.Role;
import aulas.model.Roles;
import aulas.model.Usuario;
import aulas.repository.RoleRepository;
import aulas.repository.UsuarioRepository;

@Service
public class UsuarioService {
		
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	@Autowired
	private PasswordEncoder encoder;
	public void saveUsuario(Usuario usuario) {
	
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(usuario.getRoles()==null || usuario.getRoles().size() ==0) {
			usuario.addRole(new Role(Roles.USER.name()));;
		}
		
		if(!userRepository.existsByLogin(usuario.getLogin())) {
			usuario = userRepository.save(usuario);
			
		}
		
	}
	
	
	
}
