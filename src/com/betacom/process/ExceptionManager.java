package com.betacom.process;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;

public class ExceptionManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception{
		System.out.println("Begin ExceptionManager");
		
		int p1 = 10;
		int p2 = 2;
		int res = p1/p2;			
		
		User user = new User();
		user.setNome("Pippo");
		user.setCognome("Rossi");
		validatzioneUser(user);
		
		return false;
	}

	
	private void validatzioneUser(User usr) throws AcademyException{
		if (usr.getNome() == null)
			throw new AcademyException("Nome user non validato");
		if (usr.getCognome() == null)
			throw new AcademyException("Cognome user non validato");
		if (usr.getSesso() == null)
			throw new AcademyException("Sesso user non validato");
	}
}
