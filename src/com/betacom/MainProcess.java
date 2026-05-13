package com.betacom;

import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.process.AbstractManager;
import com.betacom.process.BaseManager;
import com.betacom.process.ListManager;
import com.betacom.process.MapManager;
import com.betacom.process.DateManager;
import com.betacom.process.EnumManager;
import com.betacom.process.EreditManager;
import com.betacom.process.ExceptionManager;
import com.betacom.process.InterfacesManager;
import com.betacom.process.StringManager;
import com.betacom.utils.Utilities;

public class MainProcess {
	public static void main(String[] args) {
		
		String selected = "map";
		
		System.out.println("MainProcess is ready to execute " + selected + "  at " + Utilities.dateToString(LocalDateTime.now()) +"*********");
		GeneralProcess pr =  null;
		
		switch (selected) {
		case "base": {
			pr = new BaseManager();
			break;
		}
		case "abstract": {
			pr = new AbstractManager();
			break;
		}
		case "eredit": {
			pr = new EreditManager();
			break;
		}
		case "interface": {
			pr = new InterfacesManager();
			break;
		}
		case "string": {
			pr = new StringManager();
			break;
		}
		case "exception": {
			pr = new ExceptionManager();
			break;
		}

		case "date": {
			pr = new DateManager();
			break;
		}
		case "enum": {
			pr = new EnumManager();
			break;
		}
		case "list": {
			pr = new ListManager();
			break;
		}
		case "map": {
			pr = new MapManager();
			break;
		}

		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + selected);
		}
		
		try {
			pr.execute();
			System.out.println("** process terminato normalmente *** ");
		} catch (Exception e) {
			System.err.println("errore durante l'esecuzione:" + e.getMessage());
		}

	}
}
