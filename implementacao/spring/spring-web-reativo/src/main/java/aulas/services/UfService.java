package aulas.services;

import aulas.document.Uf;
import reactor.core.publisher.Flux;

public interface UfService {
	Flux<Uf> findAll();
}
