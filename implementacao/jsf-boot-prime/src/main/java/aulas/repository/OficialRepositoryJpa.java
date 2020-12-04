package aulas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aulas.model.Oficial;

//http://www.ciceroednilson.com.br/configurando-data-source-no-wildfly-9-com-mysql/
//https://docs.wildfly.org/20/Getting_Started_Developing_Applications_Guide.html
//@Stateless
public class OficialRepositoryJpa {
	//@PersistenceContext(unitName = "MY_PU")
	private static EntityManager entityManager ;
	public OficialRepositoryJpa() {
		
	}
	public static void main(String[] args) {
		criarConexao();
	}
	public static void criarConexao() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		if(entityManager==null) {
			entityManager = factory.createEntityManager();
			System.out.println("CRIANDO CONEXAO COM JPA e MYSQL");
		}
		
	}
    public List<Oficial> getAll(){
    	Query query = entityManager.createQuery("SELECT e FROM Oficial e "); //JQPL
		return query.getResultList();
    }

    public Oficial get(final int id) {
    	return entityManager.find(Oficial.class, id);
    }
    
    public void add(final Oficial oficial) {
    	entityManager.getTransaction().begin();
		entityManager.persist(oficial); 
		entityManager.getTransaction().commit();
    }

    public void edit(final Oficial oficial) {
    	entityManager.getTransaction().begin();
		entityManager.merge(oficial); 
		entityManager.getTransaction().commit();
    }

    public void delete(final int id) {
    	Oficial oficial =get(id);
    	
    	if(oficial!=null) {
	    	entityManager.getTransaction().begin();
			entityManager.remove(oficial); 
			entityManager.getTransaction().commit();
    	}
    	
    }
}
