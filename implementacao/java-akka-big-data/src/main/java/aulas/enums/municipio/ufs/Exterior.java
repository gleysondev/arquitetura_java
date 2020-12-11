package aulas.enums.municipio.ufs;
import aulas.enums.municipio.Municipio;

public enum Exterior implements Municipio {
	EXTERIOR (9999999,"EXTERIOR"),
	;
	private Integer id;
	private String nome;
	private Exterior(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public String getCd() {
		return id.toString();
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return "EXTERIOR";
	}
	public String getSigla() {
		return "EX";
	}
	public Integer getUf() {
		return 0;
	}
}
