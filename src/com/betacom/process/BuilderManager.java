package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Negozio;

public class BuilderManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin BuilderManager");
		
		//Negozio negoszio = new Negozio(12, "Mister Bean", "Via Rome, 12 Torino", false);
		
		Negozio negoszio = Negozio.builder()
				.codice(22)
				.isCentroCommerciale(false)
				.indirizzo("Via Rome 12- Torino")
				.proprietario("Mr bean")
				.build();				
		
		System.out.println(negoszio);
		
		return false;
	}

}
