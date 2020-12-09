package open.digytal.enums.municipio.ufs;
import open.digytal.enums.municipio.Municipio;

public enum DistritoFederal implements Municipio {
	BRASILIA (5300108,"BRASILIA"),
	;
	private Integer id;
	private String nome;
	private DistritoFederal(Integer id, String nome) {
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
		return "DISTRITO FEDERAL";
	}
	public String getSigla() {
		return "DF";
	}
	public Integer getUf() {
		return 53;
	}

}
