package com.betacom;

import com.betacom.objects.Impiegato;

public class MainEredit {

	public static void main(String[] args) {
		System.out.println("Begin MainEredit");

		Impiegato imp = new Impiegato("Paolo", "Rossi", false, 1500);
		
		System.out.println(imp);
		
		imp = new Impiegato();
		imp.setCognome("Verde");
		imp.setNome("Angelo");
		imp.setSalary(1800);
		imp.setSesso(true);
		
		System.out.println(imp);
		
	}

}
