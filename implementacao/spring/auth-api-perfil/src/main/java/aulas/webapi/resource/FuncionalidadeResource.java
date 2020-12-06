package aulas.webapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.webapi.model.Roles;
import aulas.webapi.model.acesso.Funcionalidade;
import aulas.webapi.service.FuncionalidadeService;

@RestController
@RequestMapping("/funcionalidades")
public class FuncionalidadeResource {
	@Autowired
	private FuncionalidadeService service;
	
	@PostMapping
	@PreAuthorize(Roles.FUNCIONALIDADES_INSERT)
	public void insert(@RequestBody Funcionalidade entidade) {
		service.insert(entidade);
	}
	@GetMapping
	@PreAuthorize(Roles.FUNCIONALIDADES_SEARCH)
	public List<Funcionalidade> search() {
		return service.search();
	}
}
