package aulas.mb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtils {
	public static Object getHeader(String  key) {
		 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		 Object value = externalContext.getRequestHeaderMap().get(key);
		 return value; 
	}
	public static void info(String msg) {
		 FacesContext.getCurrentInstance().addMessage(
			        null, new FacesMessage(msg));
	}
}
