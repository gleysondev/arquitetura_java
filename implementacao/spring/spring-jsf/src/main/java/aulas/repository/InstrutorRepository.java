package aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aulas.model.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {

}
