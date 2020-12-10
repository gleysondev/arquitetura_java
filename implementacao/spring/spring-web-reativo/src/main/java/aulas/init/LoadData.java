package aulas.init;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import aulas.document.Posto;
import aulas.document.Uf;
import aulas.enums.municipio.Estados;
import aulas.repository.PostoRepository;
import aulas.repository.UfRepository;
import reactor.core.publisher.Flux;


//@Component
public class LoadData implements CommandLineRunner{
	
	
	private final PostoRepository repository;
	private final UfRepository ufRepository;

	LoadData(PostoRepository pokedexRepository,UfRepository ufRepository) {

		this.repository = pokedexRepository;
		this.ufRepository=ufRepository;
	}

	@Override
	public void run(String...args) throws Exception {

		repository.deleteAll()
				.thenMany(
					Flux.just("Marechal do Ar", "Tenente Brigadeiro	", "Major Brigadeiro" , "Brigadeiro")
					.map (nome -> new Posto (UUID.randomUUID().toString(), nome))
					.flatMap(repository::save))
				
			.subscribe(System.out::println);
		
		ufRepository.deleteAll()
		.thenMany(
			Flux.fromIterable(Estados.CIDADES)
			.map (uf -> new Uf (UUID.randomUUID().toString(), uf.getNome()))
			.flatMap(ufRepository::save))
		
	.subscribe(System.out::println);
	}

	}

