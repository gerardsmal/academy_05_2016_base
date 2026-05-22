package com.betacom.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Address;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SerializzazioneManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin SerializzazioneManager");
		
		Address a = new Address();
		a.setCity("Roma");
		a.setName("Vincenzio Rossi");
		a.setSesso(true);
		a.setStreet("Via della Rosa, 23");
		a.setDesc("La mia description");
		a.setPwd("laMiaPwd");
		
		try (FileOutputStream fout = new FileOutputStream("/Users/gerard/Downloads/address.txt")){
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.flush();
			oos.close();
			
			log.debug("Object created :{}", a);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
