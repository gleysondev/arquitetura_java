package aulas.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.webapi.model.acesso.Funcionalidade;

public interface FuncionalidadeRepository extends JpaRepository<Funcionalidade, String> {

}
