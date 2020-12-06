package aulas.webapi.init;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aulas.webapi.model.acesso.Funcionalidade;
import aulas.webapi.model.acesso.Perfil;
import aulas.webapi.model.acesso.Permissao;
import aulas.webapi.model.acesso.Usuario;
import aulas.webapi.repository.UsuarioRepository;
import aulas.webapi.service.FuncionalidadeService;

@Service
public class Inicializacao {
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PasswordEncoder encoder;
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private FuncionalidadeService funcService;
	@Transactional
	public void configuracaoInicial() {
		if(repository.findByLogin("admin")==null) {
			
			
			Funcionalidade func = new Funcionalidade();
			func.setId("FUNCIONALIDADES");
			func.setNome("FUNCIONALIDADES");
			func.setIdModulo("ACESSO");
			func=em.merge(func);
			
			List<Permissao> permissoes= funcService.insert(func);
			
			Perfil perfil =new Perfil();
			perfil.setExterno(false);
			perfil.setNome("ADMIN");
			perfil.setPermissoes(permissoes);
			
			perfil = em.merge(perfil);
			
			Usuario user = new Usuario();
			user.setLogin("admin");
			String senha = encoder.encode("admin");
			user.setSenha(senha);
			user.setNome("GLEYSON SAMPAIO");
			user.setEmail("gleyson.sampaio@digytal.com.br");
			user.getPerfis().add(perfil);
			
			
			
			repository.save(user);
		};
	}
}
