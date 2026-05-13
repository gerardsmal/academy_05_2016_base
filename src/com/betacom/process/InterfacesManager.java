package com.betacom.process;

import java.util.ArrayList;

import com.betacom.interfaces.Animale;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.interfaces.Preda;
import com.betacom.interfaces.Predatore;
import com.betacom.objects.Gazella;
import com.betacom.objects.Leone;
import com.betacom.objects.Pesce;

public class InterfacesManager implements GeneralProcess{

	
	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin InterfacesManager ");
		
		ArrayList<Animale> lA = new ArrayList<Animale>();
		lA.add(new Gazella());
		lA.add(new Leone());
		lA.add(new Pesce());
		
		for (Animale it:lA) {
			identification(it);
		}

		
		return false;
	}

	private  void identification(Animale o) {
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
