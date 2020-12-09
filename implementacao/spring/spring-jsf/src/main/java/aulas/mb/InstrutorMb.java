package aulas.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import aulas.model.Instrutor;
import aulas.repository.InstrutorRepository;

/*
@Component
@ManagedBean
@ViewScoped
*/

@Named
@ViewScoped
public class InstrutorMb {
	@Autowired
	private InstrutorRepository repository;

	private Instrutor instrutor;
	
	private List<Instrutor>  instrutores;

	@PostConstruct
	public void init() {
		newInstance();
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}
	private void newInstance() {
		instrutor = new Instrutor();
		System.out.println("FIM INIT");
	}
	
	public Instrutor getInstrutor() {
		return instrutor;
	}
	
	public String listar() {
		return "lista";

	}
	public void consultar(ActionEvent event ){
		instrutores=repository.findAll();
	}
	public void cadastrar(ActionEvent event) {
		System.out.println("OK");
		repository.save(instrutor);
		newInstance();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oficial cadastrado com sucesso!"));

	}
}
