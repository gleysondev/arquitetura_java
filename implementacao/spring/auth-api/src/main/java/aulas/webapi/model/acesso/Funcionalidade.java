package aulas.webapi.model.acesso;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_acesso_funcionalidade")
public class Funcionalidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name = "id_funcionalidade")
	private String id;
	
	private String nome;
	
	private String idModulo;
	
	private boolean externa;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdModulo() {
		return idModulo;
	}
	
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	
	public boolean getExterna() {
		return externa;
	}
	
	public void setExterna(boolean externa) {
		this.externa = externa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Funcionalidade)) {
			return false;
		}
		Funcionalidade other = (Funcionalidade) obj;
		if (id == null) {
			return false;
		}
		if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Funcionalidade{id:%s}", id);
	}
	
	
}
