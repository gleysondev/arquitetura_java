package aulas.webapi.secutiry.service;

import java.util.HashSet;
import java.util.List;
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

	/*private Set<SimpleGrantedAuthority> getAuthority(Usuario user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNome()));
		});
		return authorities;
	}*/

	private Set<SimpleGrantedAuthority> getAuthority(Usuario user) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.id_permissao FROM ");
		sb.append("tab_acesso_usuario u ");
		sb.append("JOIN tab_acesso_usuario_perfil up ON u.id = up.id_usuario ");
		sb.append("JOIN tab_acesso_perfil pa ON up.id_perfil = pa.id_perfil ");
		sb.append("JOIN tab_acesso_perfil_permissao pp ON up.id_perfil = pp.id_perfil ");   
		sb.append("JOIN tab_acesso_permissao p ON pp.id_permissao = p.id_permissao ");
		sb.append("JOIN tab_acesso_funcionalidade f ON f.id_funcionalidade = p.id_funcionalidade ");
		sb.append("WHERE up.id_usuario = 1 ");
		sb.append("GROUP BY p.id_permissao	");  
		sb.append("ORDER BY p.id_permissao ");
		List<String> lista = em.createNativeQuery(sb.toString()).getResultList();
		
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		lista.forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		return authorities;
	}

}
