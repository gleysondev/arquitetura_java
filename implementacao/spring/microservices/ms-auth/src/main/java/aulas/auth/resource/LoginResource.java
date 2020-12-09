package aulas.auth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aulas.auth.model.Login;
import aulas.auth.service.LoginService;

@RestController
@RequestMapping("/login/")
public class LoginResource {
	@Autowired
	private LoginService service;
	
	@PostMapping
	public void post(@RequestBody Login login) {
		service.logar(login);
	}
}
