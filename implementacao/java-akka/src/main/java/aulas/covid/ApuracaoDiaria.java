package aulas.covid;

public class ApuracaoDiaria {
	private String estado;
	private Integer casos;
	private Integer mortes;
	private Integer recuperados;
	
	public ApuracaoDiaria(String estado, Integer casos, Integer mortes, Integer recuperados) {
		super();
		this.estado = estado;
		this.casos = casos;
		this.mortes = mortes;
		this.recuperados = recuperados;
	}
	public ApuracaoDiaria() {
		
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	
}
