package aulas;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import aulas.enums.municipio.Estados;
import aulas.enums.municipio.Municipio;

public class StreamSample {
	//https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
	public static void main(String[] args) {
		try {
			/*
			lerArquivo();
			arrays();
			filtros();
			ordenacao();
			conversao();
			
			map();
			*/
			
			sintaxe();
			
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
	
	static void filtros() {
		//Stream<Municipio> stream = Estados.CIDADES.stream();
		Stream<Municipio> stream = Estados.CIDADES.stream();
		stream = stream.filter(m -> m.getUf().equals(12));
		imprimirMunicipio(stream);
	}
	
	
	static void ordenacao() {
		
		Stream<Municipio> stream = Estados.CIDADES.stream();
		stream = stream.filter(m -> m.getUf().equals(12)).sorted(Comparator.comparingInt(Municipio::getId).reversed());
		imprimirMunicipio(stream);
		
		
	}
	static void conversao() {
		List<Municipio> sortedList = Estados.CIDADES.stream()
			.filter(m -> m.getUf().equals(12))
            .sorted(Comparator.comparingInt(Municipio::getId))
            .collect(Collectors.toList());
 
        sortedList.forEach(System.out::println);
        
	}
	static void map() {
		List<String> stringList = Estados.CIDADES.stream()
		.filter(x -> x.getUf().equals(0))		
		.map(x -> x.getEstado()).collect(Collectors.toList())
		;    
        stringList.forEach(System.out::println);
        
	}
	static void imprimirMunicipio(Stream<Municipio> conteudo) {
		conteudo.forEach(m -> System.out.println(m.getNome() + "-" + m.getSigla()));
	}
	
	
}
