package aulas.model.entidade;

import java.time.LocalDate;

public class PessoaFisica {
	private Sexo sexo;
	private LocalDate dataNascimento;
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
