package aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aulas.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	/*
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void incluir(Pessoa pessoa) {
		//pessoa.getLog().setDataInclusao(LocalDate.now());
		em.persist(pessoa);
	}
	
	public Pessoa get(Integer id) {
		return em.find(Pessoa.class, id);
		
	}
	
	@Transactional
	public void alterar(Pessoa pessoa) {
		//pessoa.getLog().setDataAlteracao(LocalDate.now());
		em.merge(pessoa);
	}
	
	public List<Pessoa> get(){
		Query q = em.createQuery("SELECT e FROM Pessoa e");
		List<Pessoa> p = q.getResultList();
		return p;
	}
	*/
}
