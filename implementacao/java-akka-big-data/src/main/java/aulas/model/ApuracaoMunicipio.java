package aulas.model;

public class ApuracaoMunicipio {
	private Integer ibge;
	private Integer casos=0;
	private Integer mortes=0;
	private Integer recuperados=0;
	
	public Integer getIbge() {
		return ibge;
	}
	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}
	public void apurarCasos(int novosCasos) {
		this.casos+=novosCasos;	
	}
	public void apurarMortes(int novosCasos) {
		this.mortes+=novosCasos;	
	}
	public void apurarRecuperados(int novosCasos) {
		this.recuperados+=novosCasos;	
	}
	
	public Integer getCasos() {
		return casos;
	}
	public Integer getMortes() {
		return mortes;
	}
	public Integer getRecuperados() {
		return recuperados;
	}
	@Override
	public String toString() {
		return "ApuracaoMunicipio [ibge=" + ibge + ", casos=" + casos + ", mortes=" + mortes + ", recuperados="
				+ recuperados + "]";
	}
	
}
