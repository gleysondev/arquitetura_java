package aulas.model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Log {
	private LocalDate dataInclusao;
	private LocalDate dataAlteracao;
	public LocalDate getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}
