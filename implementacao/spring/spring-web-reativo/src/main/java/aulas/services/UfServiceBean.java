package aulas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aulas.document.Uf;
import aulas.repository.UfRepository;
import reactor.core.publisher.Flux;

@Service
public class UfServiceBean implements UfService{

	@Autowired
	UfRepository pr;
	
	@Override
	public Flux<Uf> findAll() {
		return pr.findAll();
	}
	
	
}
