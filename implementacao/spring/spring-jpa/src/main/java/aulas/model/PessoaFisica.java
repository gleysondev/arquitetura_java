package aulas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pf")
public class PessoaFisica extends Pessoa {
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
