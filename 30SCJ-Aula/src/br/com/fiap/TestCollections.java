package br.com.fiap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		LocalDateTime before;
		LocalDateTime after;
		long tempo=0;
		
		int index=5000;
		int total=100000;
		
		System.out.println("Teste escrita ArrayList");
		before = LocalDateTime.now();
		for(int i=0; i < total; i++) arrayList.add("String"+i);
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);

		System.out.println("Teste escrita LinkedList");
		before = LocalDateTime.now();
		for(int i=0; i < total; i++) linkedList.add("String"+i);
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);

		System.out.println("Teste acesso ArrayList");
		before = LocalDateTime.now();
		System.out.println(arrayList.get(index));
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);


		System.out.println("Teste acesso LinkedList");
		before = LocalDateTime.now();
		System.out.println(linkedList.get(index));
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);
		
		System.out.println("Teste remocao ArrayList");
		before = LocalDateTime.now();
		while (arrayList.size() > 0) arrayList.remove(0);
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);

		System.out.println("Teste remocao LinkedList");
		before = LocalDateTime.now();
		while (linkedList.size() > 0 ) linkedList.remove(0);
		after = LocalDateTime.now();
		tempo = ChronoUnit.MILLIS.between(before, after);
		System.out.printf("Tempo: %s milis.\n\n", tempo);

		
	}

}
