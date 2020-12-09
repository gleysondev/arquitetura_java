package open.digytal.enums.municipio.ufs;
import open.digytal.enums.municipio.Municipio;

public enum Roraima implements Municipio {
	ALTO_ALEGRE (1400050,"ALTO ALEGRE"),
	AMAJARI (1400027,"AMAJARI"),
	BOA_VISTA (1400100,"BOA VISTA"),
	BONFIM (1400159,"BONFIM"),
	CANTA (1400175,"CANTA"),
	CARACARAI (1400209,"CARACARAI"),
	CAROEBE (1400233,"CAROEBE"),
	IRACEMA (1400282,"IRACEMA"),
	MUCAJAI (1400308,"MUCAJAI"),
	NORMANDIA (1400407,"NORMANDIA"),
	PACARAIMA (1400456,"PACARAIMA"),
	RORAINOPOLIS (1400472,"RORAINOPOLIS"),
	SAO_JOAO_DA_BALIZA (1400506,"SAO JOAO DA BALIZA"),
	SAO_LUIZ (1400605,"SAO LUIZ"),
	UIRAMUTA (1400704,"UIRAMUTA"),

	;
	private Integer id;
	private String nome;
	private Roraima(Integer id, String nome) {
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
		return "RORAIMA";
	}
	public String getSigla() {
		return "RR";
	}
	public Integer getUf() {
		return 14;
	}

}
