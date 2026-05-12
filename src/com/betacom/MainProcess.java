package com.betacom;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.process.ExceptionManager;
import com.betacom.process.StringManager;

public class MainProcess {
	public static void main(String[] args) {
		System.out.println("Begin MainProcess");
		String selected = "exception";
		
		GeneralProcess pr =  null;
		
		switch (selected) {
		case "string": {
			pr = new StringManager();
			break;
		}
		case "exception": {
			pr = new ExceptionManager();
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + selected);
		}
		
		try {
			pr.execute();
		} catch (Exception e) {
			System.err.println("errore durante l'esecuzione:" + e.getMessage());
		}

	}
}
