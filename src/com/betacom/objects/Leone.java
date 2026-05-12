package com.betacom.objects;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.Predatore;

public class Leone implements Animale,  Predatore{

	@Override
	public void sonoUnPredatore() {
		System.out.println("Sono un leone e sono un predatore");		
	}

	@Override
	public void sonoUnAnimale() {
	}

}
