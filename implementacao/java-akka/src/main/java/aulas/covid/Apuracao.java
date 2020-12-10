package aulas.covid;

public class Apuracao {
	private String estado;
	private Integer casos=0;
	private Integer mortes=0;
	private Integer recuperados=0;
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getEstado() {
		return estado;
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
}