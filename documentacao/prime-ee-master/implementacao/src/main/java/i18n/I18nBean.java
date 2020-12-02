package i18n;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

//https://www.javatpoint.com/jsf-ui-components
//https://www.tutorialspoint.com/jsf/jsf_basic_tags.htm
//http://www.mkyong.com/tutorials/jsf-2-0-tutorials/

@ManagedBean (name = "i18nBean", eager = true)
@RequestScoped

/** ATENÇÃO
 *  Window / Preference / Java / Installed JREs
 * -Duser.language=en -Duser.region=US
 * */
public class I18nBean implements Serializable {
	private String locale;
	private Map<String, Object> countries;

	@PostConstruct
	public void init() {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("Brasil", new Locale("pt", "BR"));
		locale = "Brasil";
	}
	public Map<String, Object> getCountries() {
		return countries;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	// value change event listener
	public void localeChanged(ValueChangeEvent e) {
		String newLocaleValue = e.getNewValue().toString();
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}
}
