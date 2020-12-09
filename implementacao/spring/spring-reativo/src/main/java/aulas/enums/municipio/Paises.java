package aulas.enums.municipio;

import java.time.LocalDate;

import aulas.enums.Enumeracao;

public enum Paises implements Enumeracao {
	//https://www.tecepe.com.br/olimpiadas/paises/b.htm
	//ABREVIAR
	BR(1058, "BRASIL"),

   
	;
    private Integer id;
    private String nome;
    private LocalDate dataInicio;

    private Paises(Integer id, String nome) {
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

}

