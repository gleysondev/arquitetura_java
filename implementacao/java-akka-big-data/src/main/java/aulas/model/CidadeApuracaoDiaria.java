package aulas.model;

public class CidadeApuracaoDiaria {
	private String data;
	private Integer ibge;
	private Integer uf;
	
	private Integer casos;
	private Integer mortes;
	private Integer recuperados;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getIbge() {
		return ibge;
	}
	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}
	public Integer getUf() {
		return uf;
	}
	public void setUf(Integer uf) {
		this.uf = uf;
	}
	public Integer getCasos() {
		return casos;
	}
	public void setCasos(Integer casos) {
		this.casos = casos;
	}
	public Integer getMortes() {
		return mortes;
	}
	public void setMortes(Integer mortes) {
		this.mortes = mortes;
	}
	public Integer getRecuperados() {
		return recuperados;
	}
	public void setRecuperados(Integer recuperados) {
		this.recuperados = recuperados;
	}
	public CidadeApuracaoDiaria(String data, Integer ibge, Integer uf, Integer casos, Integer mortes,
			Integer recuperados) {
		super();
		this.data = data;
		this.ibge = ibge;
		this.uf = uf;
		this.casos = casos;
		this.mortes = mortes;
		this.recuperados = recuperados;
	}
	public CidadeApuracaoDiaria() {
		
	}
	
	
}
