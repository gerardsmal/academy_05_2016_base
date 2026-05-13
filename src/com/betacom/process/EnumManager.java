package com.betacom.process;

import java.util.ArrayList;

import com.betacom.enums.Reparto;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Impiegato;

public class EnumManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin EnumManager");
		
		String valore = "SVILUPPO";
		Reparto rp = null;
		String defaulVt = "IT";
		
		try {
			rp = Reparto.valueOf(valore);			
		} catch (IllegalArgumentException e) {
			System.out.println("valore invalida. set reparto a IT");
			rp = Reparto.valueOf(defaulVt);	
		}
		
		System.out.println(rp.toString());
		
		Impiegato imp = new Impiegato("Gianni", "Verde", "M", 2500,"LOGISTICA");
		System.out.println(imp);
		
		ArrayList<Impiegato> lI = new ArrayList<Impiegato>();
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
		lI.add(new Impiegato("Maria", "Filippo", "F", 1600));
		
		String selected = "IT";
		for (Impiegato im:lI) {
			if (im.getReparto() == Reparto.valueOf(selected))
				System.out.println(im);
		}
		
		
		
		
		return false;
	}

}
