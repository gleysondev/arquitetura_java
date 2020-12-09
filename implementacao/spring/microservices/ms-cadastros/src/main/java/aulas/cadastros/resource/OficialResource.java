package aulas.cadastros.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.cadastros.model.Oficial;
import aulas.cadastros.repository.OficialRepository;

@RestController
@RequestMapping("/oficiais/")
public class OficialResource {
	@Autowired
	private OficialRepository repository;
	
	@GetMapping
	public Oficial oficial() {
		return new Oficial();
	}
	@PostMapping
	public void post(@RequestBody Oficial oficial) {
		repository.incluir(oficial);
	}
	@PutMapping
	public void put(@RequestBody Oficial oficial) {
		
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable ("id") Integer id) {
		System.out.println(id);
	}
}
