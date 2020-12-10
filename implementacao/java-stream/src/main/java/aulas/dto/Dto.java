package aulas.dto;

public class Dto {
	private Integer codigo;
	private String nome;
	
	public Dto(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
