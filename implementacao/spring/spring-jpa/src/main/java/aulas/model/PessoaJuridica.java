package aulas.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pj")
public class PessoaJuridica  extends Pessoa {
	private PorteEmpresa porte;
	public PorteEmpresa getPorte() {
		return porte;
	}
	public void setPorte(PorteEmpresa porte) {
		this.porte = porte;
	}
}
