package aulas.respository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aulas.model.Oficial;

//http://www.ciceroednilson.com.br/configurando-data-source-no-wildfly-9-com-mysql/
public class OficialRepository {
	
	private final static HashMap<Integer, Oficial> Oficials = new HashMap<>();

    public List<Oficial> getAll(){
        return new ArrayList<Oficial>(Oficials.values());
    }

    public Oficial get(final int id) {
        return Oficials.get(id);
    }

    public void add(final Oficial oficial) {
        Oficials.put(oficial.getId(), oficial);
    }

    public void edit(final Oficial oficial) {
        Oficials.remove(oficial.getId());
        Oficials.put(oficial.getId(), oficial);
    }

    public void delete(final int id) {
        Oficials.remove(id);
    }
}
