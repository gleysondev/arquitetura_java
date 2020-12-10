package aulas.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Uf {
	
	@Id
	private String Id;
	private String nome;
	
	
	public Uf(String Id, String nome) {
		super();
		this.Id = Id;
		this.nome = nome;
	}
	public Uf() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
