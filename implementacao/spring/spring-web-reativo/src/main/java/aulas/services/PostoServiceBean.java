package aulas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aulas.document.Posto;
import aulas.repository.PostoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostoServiceBean implements PostoService{

	@Autowired
	PostoRepository pr;
	
	@Override
	public Flux<Posto> findAll() {
		return pr.findAll();
	}
	
	@Override
	public Mono<Posto> findById(String Id) {
		return pr.findById(Id);
	}
	
	@Override
	public Mono<Posto> save(Posto pokedex) {
		return pr.save(pokedex);
	}
}
