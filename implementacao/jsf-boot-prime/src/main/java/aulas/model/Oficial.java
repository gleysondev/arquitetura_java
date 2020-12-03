package aulas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_oficial")
public class Oficial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String posto;
	
	private static int nextId=1;
	public Oficial() {
		//this.id=nextId++;
	}
	public void setId(Integer id) {
		this.id = id;
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
