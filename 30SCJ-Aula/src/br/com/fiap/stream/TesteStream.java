package br.com.fiap.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TesteStream {
	
	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente("João", 25, true, LocalDate.of(2016, 3, 7)));
		clientes.add(new Cliente("Maria", 23, true, LocalDate.of(2010, 6, 10)));
		clientes.add(new Cliente("José", 34, true, LocalDate.of(2017, 4, 20)));
		clientes.add(new Cliente("Francisco", 49, true, LocalDate.of(2007, 7, 7)));
		clientes.add(new Cliente("Ana", 38, true, LocalDate.of(2015, 12, 25)));
		
		clientes.stream().
		  filter(c -> ChronoUnit.YEARS.between(c.getDataPrimeiraCompra(),LocalDate.now())>5).
		  forEach(Cliente::bloqueia);
		
		double idadeMedia = clientes.stream().mapToInt(Cliente::getIdade).average().getAsDouble();
		int idadeMinima = clientes.stream().mapToInt(Cliente::getIdade).min().getAsInt();
		int idadeMaxima = clientes.stream().mapToInt(Cliente::getIdade).max().getAsInt();
		
		System.out.printf("A idade média é %s, a idade mínima é %s e a máxima é %s.\n", idadeMedia, idadeMinima, idadeMaxima);
		
		System.out.println("Clientes:");
		
		clientes.forEach(System.out::println);
		
	}

}
