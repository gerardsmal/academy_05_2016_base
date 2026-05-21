package com.betacom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.process.AbstractManager;
import com.betacom.process.AnonimaManager;
import com.betacom.process.BaseManager;
import com.betacom.process.BuilderManager;
import com.betacom.process.ListManager;
import com.betacom.process.LombokManager;
import com.betacom.process.MapManager;
import com.betacom.process.SequentialManager;
import com.betacom.process.SingleTonManager;
import com.betacom.process.StreamManager;
import com.betacom.process.DateManager;
import com.betacom.process.EnumManager;
import com.betacom.process.EreditManager;
import com.betacom.process.ExceptionManager;
import com.betacom.process.GenericsManager;
import com.betacom.process.InnerManager;
import com.betacom.process.InterfacesManager;
import com.betacom.process.JsonManager;
import com.betacom.process.StringManager;
import com.betacom.utils.Utilities;

public class MainProcess {
	public static void main(String[] args) {
		
		String selected = "lombok";
		
		System.out.println("MainProcess is ready to execute " + selected + "  at " + Utilities.dateToString(LocalDateTime.now()) +"*********");
	
		Map<String, GeneralProcess> pr = Map.ofEntries(
				Map.entry("base", new BaseManager()),
				Map.entry("abstract", new AbstractManager()),
				Map.entry("eredit", new EreditManager()),
				Map.entry("interface", new InterfacesManager()),
				Map.entry("string", new StringManager()),
				Map.entry("exception", new ExceptionManager()),
				Map.entry("enum", new EnumManager()),
				Map.entry("date", new DateManager()),
				Map.entry("list", new ListManager()),
				Map.entry("map", new MapManager()),
				Map.entry("singleton", new SingleTonManager()),
				Map.entry("generics", new GenericsManager()),
				Map.entry("sequential", new SequentialManager()),
				Map.entry("stream", new StreamManager()),
				Map.entry("anonima", new AnonimaManager()),
				Map.entry("json", new JsonManager()),
				Map.entry("inner", new InnerManager()),
				Map.entry("builder", new BuilderManager()),
				Map.entry("lombok", new LombokManager())
		);
		
		GeneralProcess ex = pr.get(selected);

		if (ex == null) {
		    throw new AcademyException("process non previsto");
		}		
		
		try {
			ex.execute();
			System.out.println("** process terminato normalmente *** ");
		} catch (Exception e) {
			System.err.println("errore durante l'esecuzione:" + e.getMessage());
		}			
		

	}
}
