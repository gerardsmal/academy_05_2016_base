package com.betacom.other;

import com.betacom.singleton.SingletonSample;

public class CallSingleTon {
	
	public void call() {
		Integer i = SingletonSample.getInstance().computeInteger();
		System.out.println("valore dal singleton da CallSingleTon :" + i);
	}

}
