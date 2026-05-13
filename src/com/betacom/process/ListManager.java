package com.betacom.process;

import java.util.ArrayList;
import java.util.List;

import com.betacom.enums.Reparto;
import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Impiegato;

public class ListManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ListManager");
		List<Impiegato> lI = load();
		listImpiegati(lI, "Dopo creazione");
		
		System.out.println();
		System.out.println("*** item 5 ***" +lI.get(5));
		try {
			System.out.println("item cancellato :" + removeFromImpiegati(lI, 5));
			listImpiegati(lI, "Dopo cancellazione");
			System.out.println("item cancellato :" + removeFromImpiegati(lI, "Pulico"));
			listImpiegati(lI, "Dopo cancellazione di Pulico");
		} catch (AcademyException  e) {
			System.err.println(e.getMessage());
		}
		lI.add(new Impiegato("Giusi", "Smalloco", "F", 1700.0, "IT"));
		listImpiegati(lI, "Dopo add Smalloco");
		
		increaseSalary(lI, "IT", 1.5);
		listImpiegati(lI, "Dopo increase Salary di 1.5");

		return false;
	}

	private List<Impiegato> load(){
		List<Impiegato> lI = new ArrayList<Impiegato>();
		lI.add(new Impiegato("Giancarlo", "Bolluci", "M", 1500.0, "IT"));
		lI.add(new Impiegato("Marco", "Lavulla", "M", 1600.0, "IT"));
		lI.add(new Impiegato("Gianni", "Danco", "M", 1700.0, "PRODUZIONE"));
		lI.add(new Impiegato("Anna", "Bella", "F", 1300.0, "LOGISTICA"));
		lI.add(new Impiegato("Beatice", "Bellona", "F", 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Marco", "Grande", "M", 2000.0, "IT"));
		lI.add(new Impiegato("Mirko", "Pulico", "M", 1800.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniel", "Andorua", "M", 1500.0, "LOGISTICA"));
		lI.add(new Impiegato("Nicolo", "Danke", "M", 1400.0, "PRODUZIONE"));
		lI.add(new Impiegato("Daniela", "Ciamplu", "F", 1900.0, "IT"));
		lI.add(new Impiegato("Angelina", "Billico", "F", 2100.0, "LOGISTICA"));
		lI.add(new Impiegato("Eric", "Lapiero", "M", 1100.0, "PRODUZIONE"));
		lI.add(new Impiegato("Piero", "Ponte", "M", 1500.0, "IT"));
		lI.add(new Impiegato("Maria", "Filippo", "F", 1600.0, "LOGISTICA"));
		lI.add(new Impiegato("Cecilia", "Marcella", "F", 1400));
		return lI;
	}
	
	private void listImpiegati(List<Impiegato> lI, String title) {
		System.out.println("************ " + title + " ******************");
		int pos = 0;
		for (Impiegato it:lI) {
			System.out.println(pos + " - " + it);
			pos++;
		}
	}
	
	private Impiegato removeFromImpiegati(List<Impiegato> lI, int pos) throws AcademyException{
		if (pos >= lI.size()) 
			throw new AcademyException("pos invalido:" + pos + " max:" + lI.size());
		
		Impiegato r = lI.get(pos);
		lI.remove(pos);
		return r;
	}
	private Impiegato removeFromImpiegati(List<Impiegato> lI, String cognome) throws AcademyException{
		int pos = 0;
		for (Impiegato it:lI) {
			if (cognome.equals(it.getCognome()))
				return removeFromImpiegati(lI, pos);
			pos++;
		}
		throw new AcademyException("cognome " + cognome + " non trovato dentro la lista");
	}
	private void increaseSalary(List<Impiegato> lI, String reparto, double f){
		for (Impiegato it:lI) {
			if (it.getReparto() == Reparto.valueOf(reparto))
				it.setSalary(it.getSalary() * f);
		}
		
	}

}
