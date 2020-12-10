package aulas.reactive;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import aulas.document.Uf;
import aulas.services.UfService;
import reactor.core.publisher.Mono;

@Component
public class UfHandler {
	
	@Autowired
	UfService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Uf.class);
	}
	
	

}
