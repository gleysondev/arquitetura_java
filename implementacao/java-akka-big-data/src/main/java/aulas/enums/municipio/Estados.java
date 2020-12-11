package aulas.enums.municipio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aulas.enums.municipio.ufs.Acre;
import aulas.enums.municipio.ufs.Alagoas;
import aulas.enums.municipio.ufs.Amapa;
import aulas.enums.municipio.ufs.Amazonas;
import aulas.enums.municipio.ufs.Bahia;
import aulas.enums.municipio.ufs.Ceara;
import aulas.enums.municipio.ufs.DistritoFederal;
import aulas.enums.municipio.ufs.EspiritoSanto;
import aulas.enums.municipio.ufs.Exterior;
import aulas.enums.municipio.ufs.Goias;
import aulas.enums.municipio.ufs.Maranhao;
import aulas.enums.municipio.ufs.MatoGrosso;
import aulas.enums.municipio.ufs.MatoGrossoSul;
import aulas.enums.municipio.ufs.MinasGerais;
import aulas.enums.municipio.ufs.Para;
import aulas.enums.municipio.ufs.Paraiba;
import aulas.enums.municipio.ufs.Parana;
import aulas.enums.municipio.ufs.Pernambuco;
import aulas.enums.municipio.ufs.Piaui;
import aulas.enums.municipio.ufs.RioGrandeNorte;
import aulas.enums.municipio.ufs.RioGrandeSul;
import aulas.enums.municipio.ufs.RioJaneiro;
import aulas.enums.municipio.ufs.Rondonia;
import aulas.enums.municipio.ufs.Roraima;
import aulas.enums.municipio.ufs.SantaCatarina;
import aulas.enums.municipio.ufs.SaoPaulo;
import aulas.enums.municipio.ufs.Sergipe;
import aulas.enums.municipio.ufs.Tocantins;

public class Estados {
	public static List<Municipio> CIDADES;
	static {
		CIDADES = new ArrayList<Municipio>();
		CIDADES.addAll(Arrays.asList(Acre.values()));
		CIDADES.addAll(Arrays.asList(Alagoas.values()));
		CIDADES.addAll(Arrays.asList(Amazonas.values()));
		CIDADES.addAll(Arrays.asList(Amapa.values()));
		CIDADES.addAll(Arrays.asList(Bahia.values()));
		CIDADES.addAll(Arrays.asList(Ceara.values()));
		CIDADES.addAll(Arrays.asList(DistritoFederal.values()));
		CIDADES.addAll(Arrays.asList(EspiritoSanto.values()));
		CIDADES.addAll(Arrays.asList(Goias.values()));
		CIDADES.addAll(Arrays.asList(Maranhao.values()));
		CIDADES.addAll(Arrays.asList(MinasGerais.values()));
		CIDADES.addAll(Arrays.asList(MatoGrossoSul.values()));
		CIDADES.addAll(Arrays.asList(MatoGrosso.values()));
		CIDADES.addAll(Arrays.asList(Para.values()));
		CIDADES.addAll(Arrays.asList(Paraiba.values()));
		CIDADES.addAll(Arrays.asList(Pernambuco.values()));
		CIDADES.addAll(Arrays.asList(Piaui.values()));
		CIDADES.addAll(Arrays.asList(Parana.values()));
		CIDADES.addAll(Arrays.asList(RioJaneiro.values()));
		CIDADES.addAll(Arrays.asList(RioGrandeNorte.values()));
		CIDADES.addAll(Arrays.asList(Rondonia.values()));
		CIDADES.addAll(Arrays.asList(Roraima.values()));
		CIDADES.addAll(Arrays.asList(RioGrandeSul.values()));
		CIDADES.addAll(Arrays.asList(SantaCatarina.values()));
		CIDADES.addAll(Arrays.asList(Sergipe.values()));
		CIDADES.addAll(Arrays.asList(SaoPaulo.values()));
		CIDADES.addAll(Arrays.asList(Tocantins.values()));
		CIDADES.addAll(Arrays.asList(Exterior.values()));
		
	}
	
	public static Municipio municipio(Integer ibge){
		for (Municipio c : CIDADES) {
			if (c.getId().equals(ibge)) {
				return c;
			}
		}
		return null;
	}
	public static List<Municipio> municipios(String nome){
		List<Municipio>list = new ArrayList<Municipio>();
		for (Municipio c : CIDADES) {
			if (c.getNome().contains(nome.toUpperCase())) {
				list.add(c);
			}
		}
		return list;
	}
	public static List<Municipio> municipios(Integer ufIbge){
		List<Municipio> lista = CIDADES.stream()
		.filter(m -> m.getUf().equals(ufIbge))
        .collect(Collectors.toList());
		return lista;
	}
	
}
