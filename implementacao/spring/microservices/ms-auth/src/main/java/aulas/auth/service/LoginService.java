package aulas.auth.service;

import org.springframework.stereotype.Service;

import aulas.auth.model.Login;

@Service
public class LoginService {
	public void logar(Login login) {
		System.out.println("Bem-vindo " + login.getUsuario());
	}
}
