package open.digytal.enums.municipio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import open.digytal.enums.municipio.ufs.Acre;
import open.digytal.enums.municipio.ufs.Alagoas;
import open.digytal.enums.municipio.ufs.Amapa;
import open.digytal.enums.municipio.ufs.Amazonas;
import open.digytal.enums.municipio.ufs.Bahia;
import open.digytal.enums.municipio.ufs.Ceara;
import open.digytal.enums.municipio.ufs.DistritoFederal;
import open.digytal.enums.municipio.ufs.EspiritoSanto;
import open.digytal.enums.municipio.ufs.Exterior;
import open.digytal.enums.municipio.ufs.Goias;
import open.digytal.enums.municipio.ufs.Maranhao;
import open.digytal.enums.municipio.ufs.MatoGrosso;
import open.digytal.enums.municipio.ufs.MatoGrossoSul;
import open.digytal.enums.municipio.ufs.MinasGerais;
import open.digytal.enums.municipio.ufs.Para;
import open.digytal.enums.municipio.ufs.Paraiba;
import open.digytal.enums.municipio.ufs.Parana;
import open.digytal.enums.municipio.ufs.Pernambuco;
import open.digytal.enums.municipio.ufs.Piaui;
import open.digytal.enums.municipio.ufs.RioGrandeNorte;
import open.digytal.enums.municipio.ufs.RioGrandeSul;
import open.digytal.enums.municipio.ufs.RioJaneiro;
import open.digytal.enums.municipio.ufs.Rondonia;
import open.digytal.enums.municipio.ufs.Roraima;
import open.digytal.enums.municipio.ufs.SantaCatarina;
import open.digytal.enums.municipio.ufs.SaoPaulo;
import open.digytal.enums.municipio.ufs.Sergipe;
import open.digytal.enums.municipio.ufs.Tocantins;

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
	public static void main(String[] args) {
		System.out.println("Cidades --> " + CIDADES.size());
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
	
}
