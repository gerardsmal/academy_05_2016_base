package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Impiegato;

public class EreditManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin EreditManager");

		Impiegato imp = new Impiegato("Paolo", "Rossi", false, 1500);
		
		System.out.println(imp);
		
		imp = new Impiegato();
		imp.setCognome("Verde");
		imp.setNome("Angelo");
		imp.setSalary(1800);
		imp.setSesso(true);
		
		System.out.println(imp);
		return false;
	}

}
