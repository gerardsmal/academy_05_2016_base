package com.betacom.objects;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;

public class Pesce implements  Animale,  Preda, Predatore{

	@Override
	public void sonoUnPredatore() {
		System.out.println("Sono un squallo e sono un predatore");
		
	}

	@Override
	public void sonoUnaPreda() {
		System.out.println("Sono un piccolo pesce e sono una preda");
		
	}

	@Override
	public void sonoUnAnimale() {
		
	}

}
