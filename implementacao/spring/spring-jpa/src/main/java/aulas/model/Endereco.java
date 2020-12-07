package aulas.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String logradouro;
	private String numero;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}
