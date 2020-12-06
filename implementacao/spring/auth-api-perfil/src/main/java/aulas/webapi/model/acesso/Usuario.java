package aulas.webapi.model.acesso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_acesso_usuario")
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(updatable = false)
	private String login;
	
	@Column(length=100)
    private String senha;
	@Column(length=50)
    private String nome;
	@Column(length=70)
    private String email;
	
	@ManyToMany
	@JoinTable(name = "tab_acesso_usuario_perfil", 
		joinColumns = { @JoinColumn(name = "id_usuario") },
		inverseJoinColumns = { @JoinColumn(name = "id_perfil") }
	)
	private List<Perfil> perfis = new ArrayList<Perfil>();
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
