package aulas.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aulas.cadastros.model.Oficial;

public interface OficialRepository  extends JpaRepository<Oficial, Integer> {

}
