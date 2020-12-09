package aulas.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aulas.document.*;
import aulas.services.PostoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PostoController {

	@Autowired
	PostoService service;
	
	
	@GetMapping(value="/pokedex")
	public Flux<Posto> getPokedex() {
		return service.findAll();
	}
	
	@GetMapping(value="/pokedex/{Id}")
	public Mono<Posto> getPokedexId(@PathVariable String Id) 
	{
		return service.findById(Id);
	}
	
	@PostMapping(value="/pokedex")
	public Mono<Posto> save (@RequestBody Posto pokedex) {
		return service.save(pokedex);
	}
	

	@GetMapping(value="/pokedex/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public  Flux<Tuple2<Long, Posto>> getPokedexByEvents() {
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		Flux<Posto> events = service.findAll();
		System.out.println("OLHA O EVENTS PASSANDO AQUIIIIIII");
		return Flux.zip(interval, events);
	}

	
	
}
