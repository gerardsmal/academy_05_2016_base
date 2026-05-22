package com.betacom.process;

import java.time.LocalDate;
import java.util.Optional;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.info("Begin OptionalManager");

		String t = "pippo";
		Optional<String> vuoto = Optional.empty();   // Optional vuoto
		Optional<String> nome  = Optional.of(t);  // caricare una valore diverse di vuoto
		
		String valore = "Paolo";
		
		Optional<String> opt = Optional.ofNullable(valore);  // caricare null o diverse da null
		
		if (opt.isPresent())
			log.debug("trovato valore {}", opt.get());       // get per dire che abbiamo verificato che optional é caricato
		
		if (opt.isEmpty())
			log.debug("valore non caricato");
		
		opt.ifPresent(n -> log.debug("valore trovata con ifPresent {}", n));
		
		Optional<String> def = Optional.of("Pippo");
		
		String resultato = def.orElse("default");
		log.debug("resultao {}", resultato);
		
		/*
		 * metodo base
		 */
		Optional<User> usr = loadUser(true);
		if (usr.isEmpty())
			throw new AcademyException("User non trovato");
		log.debug("user: {}", usr.get());
		usr.get().setCertificatoMedico(LocalDate.now());
		log.debug("user: {}", usr.get());
		
		/*
		 * metodo moderno
		 */
		User u = loadUser(false)
				.orElseThrow(() -> new AcademyException("User non trovato"));
		u.setCertificatoMedico(LocalDate.now());
		log.debug("user: {}", u);
		
		
		
		
		return false;
	}
	
	private Optional<User> loadUser(boolean load){
		User x = null;
		if (load)
			x = new User("Pippo", "Farece", true);
		Optional<User> usr = Optional.ofNullable(x);

		return usr;
	}

}
