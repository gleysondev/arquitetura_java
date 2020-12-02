package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("PeriodoConverter")
public class PeriodoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Long cep=new Long(value.replaceAll("[\\D]", ""));
		return cep;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String cep = value.toString();
		cep=cep.replaceAll("[\\D]", "");
		cep = cep.substring(0, 4) + "-" +cep.substring(4, 6);
		return cep;
	}
}