package aulas.batch;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
@Named("PropertiesService")
public class PropertiesService {
	@PersistenceContext
	private EntityManager em;
	
	private static Integer indice=0;
	private Properties properties; 
	private void load() {
		String query = "select f.cliente.id from Fatura f where f.dataFechamento = :hoje";
		Query q = em.createQuery(query).setParameter("hoje", new Date());
		List<Long> clienteIds = q.getResultList();
		int i = 0;
		properties = new Properties();
		for (Long clienteId : clienteIds) {
			properties.setProperty("clienteId"+i, String.valueOf(clienteId));
			i++;
		}
	}
	public Properties getProperties() {
		return properties;
	}
	public String getValue() {
		if(properties==null) {
			load();
		}
		return properties.getProperty("clienteId"+indice);
	}
	public void next() {
		indice++;
	}
}
