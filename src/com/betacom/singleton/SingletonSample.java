package com.betacom.singleton;

public class SingletonSample {

	private static SingletonSample instance = null;
	private Integer idx = 0;
	
	private SingletonSample() {
	
	}
	
	public static SingletonSample getInstance() {
		if (instance == null) {
			instance = new SingletonSample();
		}
		return instance;
	}
	
	public Integer computeInteger() {
		return ++idx;
	}

	
}
