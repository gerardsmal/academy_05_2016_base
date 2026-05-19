package com.betacom.process;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Impiegato;

public class AnonimaManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin AnonimaManager");
		
		/*
		 * versione senza lambda
		 */
		Azione a = new Azione() {
			
			@Override
			public void esegui(String param) {
				System.out.println("Azione eseguita con parametro :" + param);				
			}
		};		
		a.esegui("mio parametro");
		
		
		/*
		 * transformazione in lambda
		*/
		
		Azione l = (param) -> metodo(param);		
		l.esegui("second ");
		
		/*
		 * esempio con il sort senza lambda
		 */
		List<Impiegato> lI = Stream.of(
				new Impiegato("Paolo", "Verdi", true, 1300),
				new Impiegato("Pietro", "Bianchi", true, 1900),
				new Impiegato("Anna", "Rossi", false, 1400),
				new Impiegato("Giuseppe", "Giallo", true, 2000),
				new Impiegato("Alex", "Piello", true, 1900),
				new Impiegato("Cristian", "Marrone", true, 2150),
				new Impiegato("Maria", "Blue", false, 2200),
				new Impiegato("Ugo", "Noe", true, 1500)
				).collect(Collectors.toList());
		
		lI.sort(new Comparator<Impiegato>() {

			@Override
			public int compare(Impiegato o1, Impiegato o2) {
				return Double.compare(o1.getSalary(), o2.getSalary());
				}
		});
		lI.forEach(i -> System.out.println(i));
		
		/*
		 * sort chiamato con lambda
		 */
		System.out.println("Sort con lambda");
		lI.sort((Impiegato o1, Impiegato o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
		
		lI.forEach(i -> System.out.println(i));
		
		
		return false;
	}

	private void metodo(String param) {
		System.out.println("Azione eseguita con parametro :" + param);
		System.out.println("Second parametro");
	}
	
}
