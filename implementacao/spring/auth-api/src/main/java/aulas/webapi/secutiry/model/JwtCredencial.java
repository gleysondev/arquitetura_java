package aulas.webapi.secutiry.model;

import java.util.HashSet;
import java.util.Set;

public class JwtCredencial {
	private String login;
	private String token;
	public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getLogin() {
		return login;
	}
    public void setLogin(String login) {
		this.login = login;
	}
   
    
}
