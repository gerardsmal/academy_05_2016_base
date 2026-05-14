package com.betacom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.process.AbstractManager;
import com.betacom.process.BaseManager;
import com.betacom.process.ListManager;
import com.betacom.process.MapManager;
import com.betacom.process.SingleTonManager;
import com.betacom.process.DateManager;
import com.betacom.process.EnumManager;
import com.betacom.process.EreditManager;
import com.betacom.process.ExceptionManager;
import com.betacom.process.GenericsManager;
import com.betacom.process.InterfacesManager;
import com.betacom.process.StringManager;
import com.betacom.utils.Utilities;

public class MainProcess {
	public static void main(String[] args) {
		
		String selected = "generics";
		
		System.out.println("MainProcess is ready to execute " + selected + "  at " + Utilities.dateToString(LocalDateTime.now()) +"*********");
	
		Map<String, GeneralProcess> pr = new HashMap<String, GeneralProcess>();
		pr.put("base", new BaseManager());
		pr.put("abstract", new AbstractManager());
		pr.put("eredit", new EreditManager());
		pr.put("interface", new InterfacesManager());
		pr.put("string", new StringManager());
		pr.put("exception", new ExceptionManager());
		pr.put("enum", new EnumManager());
		pr.put("date", new DateManager());
		pr.put("list", new ListManager());
		pr.put("map", new MapManager());
		pr.put("singleton", new SingleTonManager());
		pr.put("generics", new GenericsManager());
		
		if (pr.containsKey(selected)) {
			try {
				GeneralProcess ex =pr.get(selected);
				ex.execute();
				System.out.println("** process terminato normalmente *** ");
			} catch (Exception e) {
				System.err.println("errore durante l'esecuzione:" + e.getMessage());
			}
			
		} else
			throw new AcademyException("process non previsto");
		

	}
}
