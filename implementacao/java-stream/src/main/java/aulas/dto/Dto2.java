package aulas.dto;

import aulas.enums.Enumeracao;

public class Dto2 {
	private Integer codigo;
	private String nome;
	public Dto2(Enumeracao e) {
		this.codigo=e.getId();
		this.nome=e.getNome();
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
}
