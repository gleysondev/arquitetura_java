package aulas.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import aulas.model.Oficial;
import aulas.respository.OficialRepositoryOld;
import external.OficialRepository;

@ManagedBean
//@ViewScoped
@SessionScoped
public class CadastroBean {
	private OficialRepositoryOld repository = new OficialRepositoryOld();
	
	@Inject
	@Named(value="jpa2")
	private OficialRepository repositoryJpa;
	
	private String nome;
	private String posto;
	
	private List<Oficial> lista = new ArrayList<Oficial>();
	
	@PostConstruct
	public void initDs() {
		//repositoryJpa.criarConexao();
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
	public void cadastrar(ActionEvent event) {
	   Oficial oficial = new Oficial();
	   oficial.setNome(nome);
	   oficial.setPosto(posto);
	   //repository.add(oficial);
	   repositoryJpa.add(oficial);
	   nome=null;
	   posto=null;
	   
	   FacesContext.getCurrentInstance().addMessage(
		        null, new FacesMessage("Oficial cadastrado com sucesso!"));
	   
	}
	public String consultar() {
		System.out.println("Realizando alguma a��o");
		//lista= repository.getAll();
		lista= repositoryJpa.getAll();
		return "consulta";
	}
	public String voltar() {
		System.out.println("voltando");
		return "cadastro";
	}
	public List<Oficial> getLista() {
		return lista;
	}
	
}
