package aulas.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aulas.model.Usuario;
import aulas.repository.UsuarioRepository;

@Service(value = "usuarioSecurityService")
public class UsuarioSecurityService implements UserDetailsService{
		
		@Autowired
		private UsuarioRepository repository;
		
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario user = repository.findByLogin(username);
			if(user == null){
				throw new UsernameNotFoundException("Usuário não existe");
			}
			Set<SimpleGrantedAuthority> roles=getAuthority(user);
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getSenha(), roles);
		}

		private Set<SimpleGrantedAuthority> getAuthority(Usuario user) {
	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			user.getRoles().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNome()));
			});
			return authorities;
		}
}
