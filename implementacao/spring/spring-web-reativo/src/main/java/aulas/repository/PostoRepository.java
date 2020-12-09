package aulas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import aulas.document.Posto;

public interface PostoRepository extends ReactiveMongoRepository <Posto, String>{

	
}
