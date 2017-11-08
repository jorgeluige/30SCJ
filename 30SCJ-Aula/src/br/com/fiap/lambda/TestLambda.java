package br.com.fiap.lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.fiap.lambda.Capiroto;

public class TestLambda {

	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		LocalDateTime before;
		LocalDateTime after;
		long tempo=0;
		
		int index=500;
		int total=10000;
		
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

		arrayList.forEach(i -> System.out.println(i));
		
		System.out.println("\nTeste remocao ArrayList");
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

		Capiroto capiroto = () -> 666;
		
		System.out.printf("Número do Capiroto é %s.", capiroto.getNumber());
		
		
		Runnable r = () -> { 
			for (int i=0; i < 10000; i++) try {
				System.out.println(i);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		new Thread(r).run();
		
	}

}
