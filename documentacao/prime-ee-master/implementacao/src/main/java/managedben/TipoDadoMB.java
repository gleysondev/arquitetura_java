package managedben;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import util.Escolaridade;
import util.Estado;
import util.FacesUtil;

@ManagedBean
public class TipoDadoMB {
	//http://blog.algaworks.com/conversores-jsf/
	//http://download.oracle.com/otn_hosted_doc/jdeveloper/j2ee101302/jsf_apps/eventvalidate/sf_avc_converters.html
	//http://blog.triadworks.com.br/jsf-conversao-de-datas-e-problemas-com-fuso-horario
	private String nome;
	private String email;
	private String cpf;						
	private Date nascimento;				//date
	private Integer idade; 					//integer
	private String sexo;
	private Escolaridade escolaridade; 			//enum
	private boolean primeiroEmprego; 		//boolean
	private Double pretensaoSalarial; 		//double
	private String cidade;
	private Estado estado; 					//tabela (entidade)
	private Long cep; 					//long
	private Long telefone; 				//long
	
	@PostConstruct
	public void init() {
		
	}
	public void valorPadrao(ActionEvent event) {
		
	}
	public void limpar(ActionEvent event) {
		
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public boolean isPrimeiroEmprego() {
		return primeiroEmprego;
	}
	public void setPrimeiroEmprego(boolean primeiroEmprego) {
		this.primeiroEmprego = primeiroEmprego;
	}
	public Double getPretensaoSalarial() {
		return pretensaoSalarial;
	}
	public void setPretensaoSalarial(Double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public void salvar(ActionEvent event) {		
		//FacesUtil.info("O Candidato: " + nome + " CPF:" + cpf +  " Nascido em: " + nascimento + " foi cadastrado com sucesso");
		System.out.println(this.toString());
	}
	public String direciona() {
		return "componentes";
	}
	@Override
	public String toString() {
		return "TipoDadoMB [nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento + ", telefone=" + telefone
				+ ", escolaridade=" + escolaridade + ", pretensaoSalarial=" + pretensaoSalarial + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + ", email=" + email + ", idade=" + idade + ", sexo=" + sexo
				+ ", primeiroEmprego=" + primeiroEmprego + "]";
	}
	
}
