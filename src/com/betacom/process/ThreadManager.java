package com.betacom.process;

import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.other.MyFirstThread;
import com.betacom.other.MySecondThread;
import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin ThreadManager at {}", Utilities.dateToString(LocalDateTime.now()));
		
		Thread t = new Thread(new MyFirstThread());
	
		MySecondThread secondT = new MySecondThread();
		Thread t1 = new Thread(secondT);
		
		log.debug("Threads started.....");		
		t.start();
		t.getState();
		t1.start();
		
		Thread.sleep(5*1000); // wait 5 seconds
		secondT.chiudi();
		/*
		 * status thread :
		  	NEW
			RUNNABLE
			BLOCKED
			WAITING
			TIMED_WAITING
			TERMINATED
		 */
		
		
		Thread.sleep(1*1000); // wait 1 seconds
		log.debug("MyFirstThread status.....{}", t.getState());		
		log.debug("MySecondThread status.....{}", t1.getState());		
		log.debug("ThreadManager is ended at {}", Utilities.dateToString(LocalDateTime.now()));
		return false;
	}

}
