package aulas;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import aulas.dto.Dto;
import aulas.dto.Dto2;
import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;

public class StreamSample {
	//https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
	public static void main(String[] args) {
		try {
			//lerArquivo();
			//arrays();
			//filtros();
			//ordenacao();
			//conversaoDeColecoes();
			
			//mapConversaoDeTipos();
			
			//sintaxe();
			
			//mapOutraSaida();
			
			//mapConversaoDtoConstrutor();
			
			//mapConversaoDtoConstrutorObjeto();
			predicate(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void sintaxe() {
		Runnable r = new Runnable() {
		     public void run() {
		          System.out.println("Thread com classer interna!");
		     }
		};
		new Thread(r).start();
		
		r = () -> System.out.println("Thread com função lambda!");
		new Thread(r).start();
		
		new Thread(
			    () -> System.out.println("hello world")
			).start();
		
	}
	
	static void arrays() {
		Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4, 5);
		imprimir(numbersFromValues);
		
		IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});
	}
	
	static void lerArquivo() throws Exception {
		Stream <String> lines= Files.lines(Paths.get("C:\\clientes\\forcaaerea\\arquitetura_java\\documentacao\\usf.txt"), Charset.defaultCharset());	
		imprimir(lines);
	}

	static void imprimir(Stream conteudo) {
		conteudo.forEach(c -> System.out.println(c));
	}
	
	//predicate dinamico
	static void filtros() {
		System.out.println("***FILTROS****");
		//Stream<Municipio> stream = Estados.CIDADES.stream();
		Stream<Municipio> stream = Estados.CIDADES.stream();
		stream = stream.filter(m -> m.getUf().equals(12));
		imprimirMunicipio(stream);
	}
	
	//predicate dinamico
	static void predicate(int uf) {
		System.out.println("***PREDICATE****");
		
		Predicate<Municipio> ufId = m -> m.getUf().equals(uf);
		Predicate<Municipio> nome = m -> m.getNome().startsWith("PORTO");
		
		Predicate<Municipio> full = ufId.or(nome);
		
		Stream<Municipio> stream = Estados.CIDADES.stream();
		stream = stream.filter(full);
		
		imprimirMunicipio(stream);
	}
	
	static void ordenacao() {
		System.out.println("***ORDENACAO****");
		Stream<Municipio> stream = Estados.CIDADES.stream();
		stream = stream.filter(m -> m.getUf().equals(12)).sorted(Comparator.comparing(Municipio::getNome).reversed());
		imprimirMunicipio(stream);
		
		
	}
	
	static void conversaoDeColecoes() {
		List<Municipio> sortedList = Estados.CIDADES.stream()
			.filter(m -> m.getUf().equals(12))
            .sorted(Comparator.comparingInt(Municipio::getId))
            .collect(Collectors.toList());
 
        sortedList.forEach(System.out::println);
        
	}
	
	//map para Objetos
	//conversao
	static void mapConversaoDeTipos() {
		List<String> stringList = Estados.CIDADES.stream()
		.filter(x -> x.getUf().equals(0))		
		.map(x -> x.getEstado()).collect(Collectors.toList())
		;    
        stringList.forEach(System.out::println);
        
	}
	
	//map para Objetos
	//conversao
	static void mapConversaoDtoConstrutor() {
        List<Dto> dtos = Estados.CIDADES.stream().map(
                s -> new Dto(s.getId(), s.getNome() + " " + s.getSigla())
        ).collect(Collectors.toList());
        
        dtos.forEach(m -> System.out.println(m.getCodigo()+ "-" + m.getNome()));
	}
	static void mapConversaoDtoConstrutorObjeto() {
	
		List<Dto2> dtos= Estados.CIDADES.stream()
        .map(Dto2::new)
        .collect(Collectors.toCollection(ArrayList::new));
            
        dtos.forEach(m -> System.out.println(m.getCodigo()+ "-" + m.getNome()));
	}
	
	//implementar
	//map para Output File
	static void mapOutraSaida() {
		Estados.CIDADES.stream()
		.filter(x -> x.getUf().equals(12))		
		.map(x -> x.getNome())
		.map(String::toLowerCase)
		.forEach(x->System.out.println(x));
		;    
        
	}
	
	static void imprimirMunicipio(Stream<Municipio> conteudo) {
		conteudo.forEach(m -> System.out.println(m.getNome() + "-" + m.getSigla()));
	}
	
	
}
