package aulas.enums.municipio;

public enum Estado {
	ACRE("AC","Acre",12),
	MARANHAO("MA","Maranhão",21),
	PIAUI("PI","Piauí",22),
	SAO_PAULO("SP","São Paulo",35),
	
	;
	
	private String sigla;
	private String nome;
	private Integer id;
	private Estado(String sigla, String nome, Integer id) {
		this.sigla = sigla;
		this.nome = nome;
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	public Integer getId() {
		return id;
	}
}
