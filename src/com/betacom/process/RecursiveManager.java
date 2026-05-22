package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursiveManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.info("Begin RecursiveManager");
		
		int number=3, result = 0;
		
		result = factorial(number);
		log.debug("Factorial di {} = {}", number, result);
		
		return false;
	}
	
	private int factorial(int n) {
		log.debug("factorial {}", n);
		if (n != 0)
			return n = n * factorial( n -1);
		else
			return 1;
	}

}
