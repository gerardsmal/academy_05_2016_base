package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Inner;

public class InnerManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin InnerManager");
		Inner inner = new Inner();
		inner.setFatherClass("Siamo nella class pedre");
		inner.setNumero(3);
		
		System.out.println("Class inner :" + inner.getFatherClass() + " numero:" + inner.getNumero());
		
		Inner.Figlio figlio = inner.setIntanceFiglio();
		figlio.setFiglioClass("sonos nella class figlio");
		figlio.setNumero2(22);
		
		System.out.println("Valore del figlio:" + figlio.displayNumber());
		
		Inner.Figlio.Nipote nipote = figlio.setIntanceNipote();
		nipote.setNipoteClass("Sono nella class nipote");
		nipote.setNumero3(500);
		
		System.out.println("Valore del nipote:" + nipote.displayNumberNipote());
		
		nipote.setNome("Paolo");
		nipote.setCognome("Verdi");
		System.out.println("User dentro nipote:" + nipote.getNome() + " " + nipote.getCognome());
		
		return false;
	}

}
