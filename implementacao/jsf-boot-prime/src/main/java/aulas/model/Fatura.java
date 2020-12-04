package aulas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fat")
public class Fatura {

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dataFechamento;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "fatura")
	private List<Lancamento> lancamentos;

	public Fatura() {
	}

	public Fatura(Cliente cliente, Date dataFechamento) {
		this.dataFechamento = dataFechamento;
		this.cliente = cliente;
	}

	public boolean aberta() {
		Date agora = new Date();
		return dataFechamento == null || dataFechamento.before(agora);
	}

	public Long getId() {
		return id;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}
}