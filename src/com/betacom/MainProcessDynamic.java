package com.betacom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainProcessDynamic {
	private final static String PATH_SERVICES = "com.betacom.process";
	
	public static void main(String[] args) {

		String selected = "optional";
		
		log.info("MainProcess is ready to execute {} at {} *********",selected, Utilities.dateToString(LocalDateTime.now()));
		try {
			GeneralProcess ex = (GeneralProcess) loadService(selected);
			executeOperation(ex);
			log.info("MainProcess is ended at {} *********", Utilities.dateToString(LocalDateTime.now()));
		} catch (Exception e) {
			log.error("process andato in error: {}", e.getMessage());
		}
	}
	
	private static Object loadService(String name)  throws Exception{
		try {
			
			Class<?> cl = Class.forName(PATH_SERVICES + "." + Utilities.buildClassName(name));
			Object obj = cl.getDeclaredConstructor().newInstance();
			return obj;
			
		} catch (ClassNotFoundException e) {
			throw new Exception("Servizio non previsto:" + name);
		}
		
	}
	
	private static void executeOperation(GeneralProcess myService) throws Exception{
		try {
			Method metodo = myService.getClass().getMethod("execute");
			metodo.invoke(myService);		
			
		} catch (SecurityException e) {
			throw new Exception("error di sicurezza.." + e.getMessage());
		} catch (IllegalAccessException e) {
			throw new Exception("Errore IllegalAccess" + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new Exception("Errore IllegalArgument" + e.getMessage());
		} catch (InvocationTargetException e) {            // retrieve error from invoke method (AcademyException)
			e.getCause().printStackTrace();
			throw new Exception(e.getCause().getMessage());
		} catch (NoSuchMethodException e) {
			throw new Exception("metodo 'execute' non trovato" );
		}
	}
}
