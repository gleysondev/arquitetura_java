package aulas.util;

import java.text.Normalizer;

public class Texto {
	public static String substring(String texto, Integer max) {
		return texto==null?"": texto.substring(0,Math.min(max, texto.length()));
	}
	public static String nomeBancoDados(String nome) {
		return nome==null?"": nomeBancoDados(nome, nome.length());
	}
	public static String nomeBancoDados(String nome, int max) {
		if(nome==null)
			return "";
		else {
			nome=Texto.substring(nome,max);
		
			return Normalizer.normalize(nome.toUpperCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}
	}
}
