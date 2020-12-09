package aulas.init;

import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import aulas.document.Posto;
import aulas.repository.PostoRepository;
import reactor.core.publisher.Flux;


@Component
public class LoadData implements CommandLineRunner{
	
	
	private final PostoRepository pokedexRepository;

	LoadData(PostoRepository pokedexRepository) {

		this.pokedexRepository = pokedexRepository;
	}

	@Override
	public void run(String...args) throws Exception {

	pokedexRepository.deleteAll()
				.thenMany(
					Flux.just("Marechal do Ar", "Tenente Brigadeiro	", "Major Brigadeiro" , "Brigadeiro")
					.map (nome -> new Posto (UUID.randomUUID().toString(), nome))
					.flatMap(pokedexRepository::save))
				
			.subscribe(System.out::println);
	}

	}

