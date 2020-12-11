package aulas.model;

import java.util.HashMap;
import java.util.Map;

public class ApuracaoEstado {
	private Integer uf;
	private Integer casos=0;
	private Integer mortes=0;
	private Integer recuperados=0;
	private Map<Integer, ApuracaoMunicipio> municipios = new HashMap<Integer, ApuracaoMunicipio>();
	public Integer getUf() {
		return uf;
	}
	public Map<Integer, ApuracaoMunicipio> getMunicipios() {
		return municipios;
	}
	
	public ApuracaoMunicipio getApuracaoMunicipio(Integer ibge) {
		ApuracaoMunicipio item = municipios.get(ibge);
		if(item==null) {
			item = new ApuracaoMunicipio();
			municipios.put(ibge, item);
		}
		return item;
	}
	
	
}
