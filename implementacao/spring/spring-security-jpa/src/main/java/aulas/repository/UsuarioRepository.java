package aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByLogin(String login);
	boolean existsByLogin(String login);
}