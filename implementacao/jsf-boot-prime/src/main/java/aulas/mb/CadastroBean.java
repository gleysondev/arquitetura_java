package aulas.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import aulas.mb.util.FacesUtils;
import aulas.model.Oficial;
import aulas.repository.OficialRepositoryJpa;

@ManagedBean
@SessionScoped
public class CadastroBean  {
	private OficialRepositoryJpa repository = new OficialRepositoryJpa();

	private Oficial oficial;
	private List<Oficial> lista = new ArrayList<Oficial>();
	
	
	private void novoOficial() {
		oficial = new Oficial();
	}
	@PostConstruct
	public void initBean() {
		repository.criarConexao();
		System.out.println("InitBean");
		novoOficial();
		
	}
	public Oficial getOficial() {
		return oficial;
	}
	
	public void setOficial(Oficial oficial) {
		this.oficial = oficial;
	}
	
	public void cadastrar(ActionEvent event) {
	   //repository.add(oficial);
	   repository.add(oficial);
	   novoOficial();
	   
	}
	public void pesquisar(ActionEvent event) {
		lista= repository.getAll();
		   
		}
	
	public String consultar() {
		System.out.println("Realizando alguma a��o");
		//lista= repository.getAll();
		lista= repository.getAll();
		return "consulta";
	}
	public String voltar() {
		System.out.println("voltando");
		
		Object value = FacesUtils.getHeader("");
		 System.out.println(value);
		return "cadastro";
	}
	public List<Oficial> getLista() {
		return lista;
	}
}
