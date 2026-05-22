package com.betacom.other;

import java.time.LocalDateTime;

import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySecondThread implements Runnable{
	private boolean attiva = true; 
	
	@Override
	public void run() {
		log.debug("Begin MySecondThread at:{}", Utilities.dateToString(LocalDateTime.now()));
		
		while (attiva) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				this.attiva = false;
			}
			
			
		}
		log.debug("Ended MySecondThread at:{}", Utilities.dateToString(LocalDateTime.now()));
		
	}

	public void chiudi() {
		log.debug("chiudi is called at {}", Utilities.dateToString(LocalDateTime.now()));
		this.attiva = false;
	}
}
