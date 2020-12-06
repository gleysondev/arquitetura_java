package aulas.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.webapi.model.acesso.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, String> {

}
