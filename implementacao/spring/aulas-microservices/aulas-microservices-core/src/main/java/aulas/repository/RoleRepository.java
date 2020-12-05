package aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.model.Role;

public interface RoleRepository  extends JpaRepository<Role, String> {
	Role findByNome(String nome);
}
