package aulas.model.entidade;

public enum Sexo {
	//Ordinal - JPA
	MASCULINO("MASCULINO"),
	FEMININO("FEMININO"),
	//String - JPA
	M("MASCULINO"),
	F("FEMININO"),;
	
	private String descricao;
	private Sexo(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	
}
