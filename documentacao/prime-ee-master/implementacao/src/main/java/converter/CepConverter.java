package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CepConverter")
public class CepConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Long cep=new Long(value.replaceAll("[\\D]", ""));
		return cep;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String cep = value.toString();
		cep=cep.replaceAll("[\\D]", "");
		cep = cep.substring(0, 5) + "-" +cep.substring(5, 8);
		return cep;
	}
	public static void main(String[] args) {
		//http://aurelio.net/regex/
		//http://aurelio.net/regex/guia/
		//http://piazinho.com.br/download/expressoes-regulares-3-tabelas.pdf
		//https://pablonobrega.wordpress.com/2009/08/10/implementando-converter-e-validator-de-cpf/
		//http://www.mkyong.com/jsf2/custom-converter-in-jsf-2-0/
		String cep =  "12345678";
		cep = cep.substring(0, 5) + "-" + cep.substring(5, 8);
		System.out.println(cep);
		cep = cep.replaceAll("[\\D]", "");
		System.out.println(cep);
	}
}


