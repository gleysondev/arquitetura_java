package external;

import java.util.List;

import aulas.model.Oficial;

public interface OficialRepository {
	public void add(final Oficial oficial);
	 public List<Oficial> getAll();
}
