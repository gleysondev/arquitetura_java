package aulas.model;

public class Oficial {
	private Integer id;
	private String nome;
	private String posto;
	
	private static int nextId=1;
	public Oficial() {
		this.id=nextId++;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public Integer getId() {
		return id;
	}
	
}
