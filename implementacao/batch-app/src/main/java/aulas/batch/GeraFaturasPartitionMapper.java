package aulas.batch;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Dependent
@Named("GeraFaturasPartitionMapper")
public class GeraFaturasPartitionMapper implements PartitionMapper {

	@PersistenceContext
	private EntityManager em;

	@Override
	public PartitionPlan mapPartitions() throws Exception {
		return new PartitionPlanImpl() {

			private List<Long> clienteIds;

			private void init() {
				String query = "select f.cliente.id from Fatura f where f.dataFechamento = :hoje";
				Query q = em.createQuery(query).setParameter("hoje", new Date());
				clienteIds = q.getResultList();
			}

			@Override
			public int getPartitions() {
				if (clienteIds == null)
					init();
				return clienteIds.size();
			}

			@Override
			public Properties[] getPartitionProperties() {
				Properties[] propriedades = new Properties[getPartitions()];
				int i = 0;
				for (Long clienteId : clienteIds) {
					propriedades[i] = new Properties();
					//propriedades[i].put("clienteId", clienteId);
					propriedades[i].setProperty("clienteId", String.valueOf(clienteId));
					i++;
				}
				return propriedades;
			}
		};
	}
}