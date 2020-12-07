package aulas.model;

/**
 * 
 * @author gleys
 *
 */
public enum Sexo {
	F("FEMININO"),
	M("MASCULINO"),
	SG("INDEFINIDO")
	;
	
	private String descricao;
	
	private Sexo(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}

}
