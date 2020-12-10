package aulas.services;
 import aulas.document.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostoService {
	
	Flux<Posto> findAll();
	Mono<Posto> findById(String Id);
	Mono<Posto> save(Posto posto);

}
