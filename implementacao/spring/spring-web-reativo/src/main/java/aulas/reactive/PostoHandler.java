package aulas.reactive;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import aulas.document.Posto;
import aulas.services.PostoService;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;

@Component
public class PostoHandler {
	
	@Autowired
	PostoService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Posto.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String Id = request.pathVariable("Id");
		return ok()
				
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(Id), Posto.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Posto> pokedex = request.bodyToMono(Posto.class);
		return ok()
				
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(pokedex.flatMap(service::save), Posto.class));
	}

}
