package managedben;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import util.FacesUtil;

@ManagedBean(name="validacaoServidorMB")
public class ValidacaoServidorMB {
	private String nome;
	private String email;
	private String cpf;						
	private Date nascimento;				//date
	private Integer idade; 					//integer
	private String sexo;
	private String escolaridade; 			//enum
	private String primeiroEmprego; 		//boolean
	private String pretensaoSalarial; 		//double
	private String cidade;
	private String estado; 					//tabela (entidade)
	private String cep; 					//long
	private Long telefone; 				//long
	
	@PostConstruct
	public void init() {
		
	}
	public void valorPadrao(ActionEvent event) {
		nome="GLEYSON";
		cpf="11309822947";						
		nascimento=new Date();		
		idade=30; 
		sexo="M";
		escolaridade="M"; 
		primeiroEmprego="S";
		pretensaoSalarial="1234";
		cidade="SANTA INES";
		estado="MA"; 
		cep="65300000";
		telefone=11934730287L;
	}
	public void limpar(ActionEvent event) {
		nome="";
		cpf="";						
		nascimento=null;
		idade=null;
		sexo="";
		escolaridade="";
		primeiroEmprego="";
		pretensaoSalarial="";
		cidade="";
		estado="";
		cep="";
		telefone=null;
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
}
