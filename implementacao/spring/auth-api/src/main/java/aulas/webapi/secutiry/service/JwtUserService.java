package aulas.webapi.secutiry.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.UsuarioRepository;

/*
 Agora iremos criar uma classe JwtUserDetailsService que implementa a UserDetailsService do spring security e checar o login do usuário,
  nesse tutorial o usuário e a senha serão fixos no código, em um tutorial futuro iremos buscar esses dados no banco.
 
 */

@Service(value = "userService")
public class JwtUserService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@PersistenceContext
	private EntityManager em;
	
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
