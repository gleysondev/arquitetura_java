package aulas.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.webapi.model.acesso.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByLogin(String login);
	boolean existsByLogin(String login);
}