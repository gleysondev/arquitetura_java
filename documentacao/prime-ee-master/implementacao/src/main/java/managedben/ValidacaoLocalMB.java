package managedben;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import util.FacesUtil;

@ManagedBean(name="validacaoLocalMB")
@ViewScoped
public class ValidacaoLocalMB {
	private String nome;
	private String email;
	private String cpf;						
	private String nascimento;				//date
	private String idade; 					//integer
	private String sexo;
	private String escolaridade; 			//enum
	private String primeiroEmprego; 		//boolean
	private String pretensaoSalarial; 		//double
	private String cidade;
	private String estado; 					//tabela (entidade)
	private String cep; 					//long
	private String telefone; 				//long
	
	@PostConstruct
	public void init() {
		
	}
	public void valorPadrao(ActionEvent event) {
		nome="GLEYSON";
		cpf="11309822947";						
		nascimento="10/10/2018";		
		idade="30"; 
		sexo="M";
		escolaridade="M"; 
		primeiroEmprego="S";
		pretensaoSalarial="1234";
		cidade="SANTA INES";
		estado="MA"; 
		cep="65300000";
		telefone="11934730287";
	}
	public void limpar(ActionEvent event) {
		nome="";
		cpf="";						
		nascimento="";
		idade="";
		sexo="";
		escolaridade="";
		primeiroEmprego="";
		pretensaoSalarial="";
		cidade="";
		estado="";
		cep="";
		telefone="";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getPrimeiroEmprego() {
		return primeiroEmprego;
	}
	public void setPrimeiroEmprego(String primeiroEmprego) {
		this.primeiroEmprego = primeiroEmprego;
	}
	public String getPretensaoSalarial() {
		return pretensaoSalarial;
	}
	public void setPretensaoSalarial(String pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void salvar(ActionEvent event) {		
		FacesUtil.info("O Candidato: " + nome + " CPF:" + cpf +  " Nascido em: " + nascimento + " foi cadastrado com sucesso");
	}
	public String direciona() {
		return "componentes";
	}
}
