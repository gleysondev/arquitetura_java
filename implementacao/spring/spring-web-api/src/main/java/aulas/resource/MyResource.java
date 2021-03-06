package aulas.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.model.Oficial;

@RestController
@RequestMapping("/oficiais/")
public class MyResource {
	@GetMapping
	public Oficial oficial() {
		return new Oficial();
	}
	@PostMapping
	public void post(@RequestBody Oficial oficial) {
		
	}
	@PutMapping
	public void put(@RequestBody Oficial oficial) {
		
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable ("id") Integer id) {
		System.out.println(id);
	}
}
