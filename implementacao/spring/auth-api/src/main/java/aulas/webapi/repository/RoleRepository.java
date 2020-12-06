package aulas.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.webapi.model.acesso.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>  {

	
}
