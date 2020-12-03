package external;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import aulas.model.Oficial;

//http://www.ciceroednilson.com.br/configurando-data-source-no-wildfly-9-com-mysql/
//https://docs.wildfly.org/20/Getting_Started_Developing_Applications_Guide.html

@Stateless
@Named(value = "jpa")
public class OficialRepositoryJpa implements OficialRepository {
	
	@PersistenceContext(unitName = "MY_PU")
	private EntityManager entityManager ;
	
    public List<Oficial> getAll(){
    	System.out.println("JPA");
    	Query query = entityManager.createQuery("SELECT e FROM Oficial e "); //JQPL
		return query.getResultList();
    }

    public Oficial get(final int id) {
    	return entityManager.find(Oficial.class, id);
    }
    
    @Transactional
    public void add(final Oficial oficial) {
    	//entityManager.getTransaction().begin();
		entityManager.persist(oficial); 
		//entityManager.getTransaction().commit();
    }

    public void edit(final Oficial oficial) {
    	entityManager.getTransaction().begin();
		entityManager.merge(oficial); 
		entityManager.getTransaction().commit();
    }

    public void delete(final int id) {
    	Oficial oficial =get(id);
    	
    	if(oficial!=null) {
	    	//entityManager.getTransaction().begin();
			entityManager.remove(oficial); 
			//entityManager.getTransaction().commit();
    	}
    	
    }
}
