package aulas.cadastros.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.cadastros.model.Oficial;
import aulas.cadastros.repository.OficialRepository;

@RestController
@RequestMapping("/v1/cadastros")
public class OficialResource {
	@Autowired
	private OficialRepository repository;
	
	@PostMapping(path = "/oficiais", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void incluir(@RequestBody Oficial entidade) {
		repository.save(entidade);
	}
	
	@GetMapping(path = "/oficiais", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Oficial> listar() {
		return repository.findAll();
	}
	
}
