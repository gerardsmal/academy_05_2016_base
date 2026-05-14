package com.betacom.process;

import java.util.ArrayList;
import java.util.List;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.GenericsResponse;
import com.betacom.objects.Impiegato;
import com.betacom.objects.User;

public class GenericsManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin GenericsManager");
		
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
		
		GenericsResponse<Impiegato, String> resp = new GenericsResponse<Impiegato, String>();
		resp.setRc(true);
		resp.setOher("Tutto ok");
		resp.setData(lI);
		
		
		System.out.println(resp);
		
		List<User> lU = new ArrayList<User>();
		lU.add(new User("Paolo", "Berat", "M", 1979, 5, 9));
		lU.add(new User("Anna", "Cloni", "F", 1999, 10, 12));
		lU.add(new User("Gianni", "Smurl", "M", 2000, 1, 25));
		lU.add(new User("Maria", "Angela", "F", 2005, 5, 15));
		
		GenericsResponse<User, Integer> r1 = new  GenericsResponse<User, Integer>();
		r1.setRc(true);
		r1.setOher(24);
		r1.setData(lU);
		
		System.out.println(r1);
		
		
		return false;
	}

}
