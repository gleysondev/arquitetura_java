package aulas.cadastros.repository;

import org.springframework.stereotype.Repository;

import aulas.cadastros.model.Oficial;

@Repository
public class OficialRepository {
	public void incluir(Oficial oficial) {
		System.out.println("Incluindo o oficial " + oficial.getNome());
	}
}
