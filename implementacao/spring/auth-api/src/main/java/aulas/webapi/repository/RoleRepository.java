package aulas.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aulas.webapi.model.acesso.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>  {

	
}
