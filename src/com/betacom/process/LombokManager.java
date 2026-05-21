package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.LombokObject;
import com.betacom.objects.ObjectFiglio;
import com.betacom.objects.ObjectPadre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.info("Begin LombokManager");
		
		LombokObject obj = new LombokObject();
		obj.setCognome("Rossi");
		obj.setNome("Andrea");
		obj.setSesso(true);
		
		log.debug("obj: {}" , obj);
		
		obj = new LombokObject("Bruno", "Laverdura", "Via della rosa", true);
		log.debug("obj: {}" , obj);
		
		obj = LombokObject.builder()
				.cognome("Grande")
				.nome("Alice")
				.sesso(false)
				.build();
		
		log.debug("obj: {}" , obj);

		ObjectFiglio fi = ObjectFiglio.builder()
				.nome("Bianca")
				.cognome("Berni")
				.citta("Torino")
				.indirizzo("via della luna")
				.sesso(false)
				.build();
		
		log.debug("figlio: {}" , fi);
		
//		ObjectPadre p = ObjectPadre.builder()
//				.cognome("Miopadre")
//				.nome("Io")
//				.build();
//		
//		System.out.println("padre" + p);
//		

		return false;
	}

}
