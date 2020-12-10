package aulas.enums.municipio.ufs;
import aulas.enums.municipio.Municipio;

public enum Rondonia implements Municipio {
	ALTA_FLORESTA_DOESTE (1100015,"ALTA FLORESTA DOESTE"),
	ALTO_ALEGRE_DOS_PARECIS (1100379,"ALTO ALEGRE DOS PARECIS"),
	ALTO_PARAISO (1100403,"ALTO PARAISO"),
	ALVORADA_DOESTE (1100346,"ALVORADA DOESTE"),
	ARIQUEMES (1100023,"ARIQUEMES"),
	BURITIS (1100452,"BURITIS"),
	CABIXI (1100031,"CABIXI"),
	CACAULANDIA (1100601,"CACAULANDIA"),
	CACOAL (1100049,"CACOAL"),
	CAMPO_NOVO_DE_RONDONIA (1100700,"CAMPO NOVO DE RONDONIA"),
	CANDEIAS_DO_JAMARI (1100809,"CANDEIAS DO JAMARI"),
	CASTANHEIRAS (1100908,"CASTANHEIRAS"),
	CEREJEIRAS (1100056,"CEREJEIRAS"),
	CHUPINGUAIA (1100924,"CHUPINGUAIA"),
	COLORADO_DO_OESTE (1100064,"COLORADO DO OESTE"),
	CORUMBIARA (1100072,"CORUMBIARA"),
	COSTA_MARQUES (1100080,"COSTA MARQUES"),
	CUJUBIM (1100940,"CUJUBIM"),
	ESPIGAO_DOESTE (1100098,"ESPIGAO DOESTE"),
	GOVERNADOR_JORGE_TEIXEIRA (1101005,"GOVERNADOR JORGE TEIXEIRA"),
	GUAJARA_MIRIM (1100106,"GUAJARA-MIRIM"),
	ITAPUA_DO_OESTE (1101104,"ITAPUA DO OESTE"),
	JARU (1100114,"JARU"),
	JI_PARANA (1100122,"JI-PARANA"),
	MACHADINHO_DOESTE (1100130,"MACHADINHO DOESTE"),
	MINISTRO_ANDREAZZA (1101203,"MINISTRO ANDREAZZA"),
	MIRANTE_DA_SERRA (1101302,"MIRANTE DA SERRA"),
	MONTE_NEGRO (1101401,"MONTE NEGRO"),
	NOVA_BRASILANDIA_DOESTE (1100148,"NOVA BRASILANDIA DOESTE"),
	NOVA_MAMORE (1100338,"NOVA MAMORE"),
	NOVA_UNIAO (1101435,"NOVA UNIAO"),
	NOVO_HORIZONTE_DO_OESTE (1100502,"NOVO HORIZONTE DO OESTE"),
	OURO_PRETO_DO_OESTE (1100155,"OURO PRETO DO OESTE"),
	PARECIS (1101450,"PARECIS"),
	PIMENTA_BUENO (1100189,"PIMENTA BUENO"),
	PIMENTEIRAS_DO_OESTE (1101468,"PIMENTEIRAS DO OESTE"),
	PORTO_VELHO (1100205,"PORTO VELHO"),
	PRESIDENTE_MEDICI (1100254,"PRESIDENTE MEDICI"),
	PRIMAVERA_DE_RONDONIA (1101476,"PRIMAVERA DE RONDONIA"),
	RIO_CRESPO (1100262,"RIO CRESPO"),
	ROLIM_DE_MOURA (1100288,"ROLIM DE MOURA"),
	SANTA_LUZIA_DOESTE (1100296,"SANTA LUZIA DOESTE"),
	SAO_FELIPE_DOESTE (1101484,"SAO FELIPE DOESTE"),
	SAO_FRANCISCO_DO_GUAPORE (1101492,"SAO FRANCISCO DO GUAPORE"),
	SAO_MIGUEL_DO_GUAPORE (1100320,"SAO MIGUEL DO GUAPORE"),
	SERINGUEIRAS (1101500,"SERINGUEIRAS"),
	TEIXEIROPOLIS (1101559,"TEIXEIROPOLIS"),
	THEOBROMA (1101609,"THEOBROMA"),
	URUPA (1101708,"URUPA"),
	VALE_DO_ANARI (1101757,"VALE DO ANARI"),
	VALE_DO_PARAISO (1101807,"VALE DO PARAISO"),
	VILHENA (1100304,"VILHENA"),

	;
	private Integer id;
	private String nome;
	private Rondonia(Integer id, String nome) {
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
		return "RONDONIA";
	}
	public String getSigla() {
		return "RO";
	}
	public Integer getUf() {
		return 11;
	}

}
