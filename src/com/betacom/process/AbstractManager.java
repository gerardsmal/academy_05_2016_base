package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.BMW;
import com.betacom.objects.Fiat500;

public class AbstractManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin AbstractManager");

		Fiat500 fiat = new Fiat500();
		fiat.setColor("Nero");
		fiat.setMaxSpeed(130);
		fiat.setModel("Fiat 500");
		
		fiat.accelera();
		fiat.frena();
		
		System.out.println("Model:" + fiat.getModel() + " colore:" + fiat.getColor() + " speed:" + fiat.getMaxSpeed());
		
		BMW bmw = new BMW();
		
		bmw.setColor("Bianca");
		bmw.setMaxSpeed(250);
		bmw.setModel("M3");
		
		bmw.accelera();
		bmw.frena();
		
		System.out.println("Model:" + bmw.getModel() + " colore:" + bmw.getColor() + " bmw:" + fiat.getMaxSpeed());
		return false;
	}

}
