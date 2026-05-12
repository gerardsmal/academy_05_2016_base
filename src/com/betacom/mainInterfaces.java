package com.betacom;

import java.util.ArrayList;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;
import com.betacom.objects.Gazella;
import com.betacom.objects.Leone;
import com.betacom.objects.Pesce;

public class mainInterfaces {

	public static void main(String[] args) {
		System.out.println("Begin mainInterfaces ");
		
		ArrayList<Animale> lA = new ArrayList<Animale>();
		lA.add(new Gazella());
		lA.add(new Leone());
		lA.add(new Pesce());
		
		for (Animale it:lA) {
			identification(it);
		}
	}
	
	private static void identification(Animale o) {
		if (o instanceof Preda) {
			Preda obj = (Preda)o;
			obj.sonoUnaPreda();
		}
		if (o instanceof Predatore) {
			Predatore obj = (Predatore)o;
			obj.sonoUnPredatore();
		}

	}

}
