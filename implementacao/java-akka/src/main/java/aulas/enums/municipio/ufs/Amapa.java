package aulas.enums.municipio.ufs;

import aulas.enums.municipio.Municipio;

public enum Amapa implements Municipio {
	AMAPA (1600105,"AMAPA"),
	CALCOENE (1600204,"CALCOENE"),
	CUTIAS (1600212,"CUTIAS"),
	FERREIRA_GOMES (1600238,"FERREIRA GOMES"),
	ITAUBAL (1600253,"ITAUBAL"),
	LARANJAL_DO_JARI (1600279,"LARANJAL DO JARI"),
	MACAPA (1600303,"MACAPA"),
	MAZAGAO (1600402,"MAZAGAO"),
	OIAPOQUE (1600501,"OIAPOQUE"),
	PEDRA_BRANCA_DO_AMAPARI (1600154,"PEDRA BRANCA DO AMAPARI"),
	PORTO_GRANDE (1600535,"PORTO GRANDE"),
	PRACUUBA (1600550,"PRACUUBA"),
	SANTANA (1600600,"SANTANA"),
	SERRA_DO_NAVIO (1600055,"SERRA DO NAVIO"),
	TARTARUGALZINHO (1600709,"TARTARUGALZINHO"),
	VITORIA_DO_JARI (1600808,"VITORIA DO JARI"),

	;
	private Integer id;
	private String nome;
	private Amapa(Integer id, String nome) {
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
		return "AMAPA";
	}
	public String getSigla() {
		return "AP";
	}
	public Integer getUf() {
		return 16;
	}
}
