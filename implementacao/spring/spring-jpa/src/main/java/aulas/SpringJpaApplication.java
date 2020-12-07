package aulas;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aulas.model.Pessoa;
import aulas.model.PessoaFisica;
import aulas.model.PessoaJuridica;
import aulas.model.PorteEmpresa;
import aulas.model.Sexo;
import aulas.repository.PessoaRepository;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(PessoaRepository bean) {
        return args -> {
        	/*
        	Pessoa p = new Pessoa();
        	p.setNome("GLEYSON");
        	//p.addDocumento("RG", "123");
        	
        	Telefone t = new Telefone();
        	t.setDdd("11");
        	t.setNumero("12313212");
        	p.addTelefone(t);
        	
        	bean.incluir(p);
        	
        	List<Pessoa> get = bean.get();
        	System.out.println(get);
        	*/
        	
    		PessoaFisica pp = new PessoaFisica();
    		pp.setNome("GLEYSON 2");
    		pp.setSexo(Sexo.M);
    		bean.save(pp);
        	
    		PessoaJuridica pj = new PessoaJuridica();
    		pj.setNome("GLEYSON PJ");
    		pj.setPorte(PorteEmpresa.G);
    		bean.save(pj);
        	
        };
    }
}
