package aulas.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aulas.document.Posto;
import aulas.services.PostoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PostoController {

	@Autowired
	PostoService service;
	
	@GetMapping(value="/posto/{Id}")
	public Mono<Posto> getpostoId(@PathVariable String Id) 
	{
		return service.findById(Id);
	}
	
	@PostMapping(value="/posto")
	public Mono<Posto> save (@RequestBody Posto posto) {
		return service.save(posto);
	}
	
	@GetMapping(value="/posto")
	public Flux<Posto> getposto() {
		return service.findAll();
	}

	@GetMapping(value="/posto/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public  Flux<Tuple2<Long, Posto>> getpostoByEvents() {
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<Posto> events = service.findAll();
		System.out.println("OLHA O EVENTS PASSANDO AQUIIIIIII " + events);
		return Flux.zip(interval, events);
		
	}

	
	
}
