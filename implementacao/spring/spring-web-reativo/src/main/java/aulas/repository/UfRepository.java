package aulas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import aulas.document.Uf;

public interface UfRepository extends ReactiveMongoRepository <Uf, String>{

	
}
