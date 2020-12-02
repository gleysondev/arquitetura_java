package managedben;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import util.FacesUtil;

@ManagedBean
public class ClienteMB implements Serializable {
	private String nome;
	private String credito;
	private String endereco;
	private String bairro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	
	@PostConstruct
	public void init() {
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCredito() {
		return credito;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public void salvar(ActionEvent event) {
		FacesUtil.info("Cliente salvo com sucesso");
	}
	public String direciona() {
		return "componentes";
	}
	
}
