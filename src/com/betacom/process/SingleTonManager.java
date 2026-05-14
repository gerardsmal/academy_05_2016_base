package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.other.CallSingleTon;
import com.betacom.singleton.SingletonSample;

public class SingleTonManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin SingleTonManager");
		
		Integer i = SingletonSample.getInstance().computeInteger();
		System.out.println("Valore indice del singleton:" + i);
		
		new CallSingleTon().call();
	
		i = SingletonSample.getInstance().computeInteger();
		System.out.println("Valore indice dopo il call:" + i);
	
		return false;
	}

}
