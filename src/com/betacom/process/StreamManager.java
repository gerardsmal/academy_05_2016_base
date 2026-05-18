package com.betacom.process;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;

public class StreamManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin StreamManager");
		/*
		 * create list with stream
		 */
		List<Impiegato> lI = Stream.of(
				new Impiegato("Paolo", "Verdi", true, 1300),
				new Impiegato("Pietro", "Bianchi", true, 1900),
				new Impiegato("Anna", "Rossi", false, 2000),
				new Impiegato("Giuseppe", "Giallo", true, 2100),
				new Impiegato("Alex", "Piello", true, 2200),
				new Impiegato("Cristian", "Marrone", true, 2150),
				new Impiegato("Maria", "Blue", false, 2200),
				new Impiegato("Ugo", "Noe", true, 1500)
				).collect(Collectors.toList());
		
		lI.add(new Impiegato("Ugo", "Verde", true, 2500));
		
		lI.forEach(it -> System.out.println(it));
		
		/*
		 * create stream with builder
		 */
		Stream<String> streamBuilder = Stream.<String> builder()
				.add("lunedi")
				.add("martedi")
				.add("mercoledi")
				.add("giovedi")
				.add("venerdi")
				.add("sabato")
				.add("domenica")
				.build();
		
		String[] giorni = streamBuilder.toArray(size -> new String[size]);
		System.out.println("Giorni length:" + giorni.length + " giorni[4]:" + giorni[4]);
				
		
		/*
		 * creazione random
		 */

		Random ran = new Random();
		Stream<Long> sR = Stream.generate(() -> ran.nextLong()) .limit(10);
		sR.forEach(n -> System.out.println(n));
		
		
		/*
		 * generazione dati primitive
		 */
		System.out.println("Generazione dati primitive");
		IntStream intStream = IntStream.range(3, 15);
		intStream.forEach(i -> System.out.println(i));
		
		/*
		 * filtro
		 */
		lI.stream()
			.filter(im -> im.getSesso())
			.filter(im -> im.getSalary() > 2000)
			.forEach(im -> System.out.println(im));
		
		/*
		 * map
		 */
		 List<ImpiegatoStream> lIS  = lI.stream()
				 .filter(im -> im.getSesso())
				 .filter(im -> im.getSalary() > 2000)
				 .map(imp -> new ImpiegatoStream(imp.getNome(), imp.getCognome()))
				 .toList();
		
		 lIS.forEach(i -> System.out.println(i));
		
		/*
		 * count
		 */
		 System.out.println("** count ***");
		 long count = lI.stream()
				 .filter(im -> !im.getSesso())
				 .count();
		 System.out.println("Numero di femine:" + count);
		 
		 /*
		  * match
		  */
		 boolean rm = lI.stream()
				 .filter(im -> im.getSesso())
				 .anyMatch(im -> im.getSalary() > 2500);
		 System.out.println("Result del match:" + rm);
		 
		
		return false;
	}

}
