package com.betacom.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.betacom.interfaces.GeneralProcess;

public class MapManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin MapManager");
		Map<String, String> map = createMap();
		
		System.out.println("numero elementi della map:" + map.size());
	
		String keySearch = "k4";
		String value = null;
		if (map.containsKey(keySearch)) {
			value = map.get(keySearch);
			System.out.println("valore di " + keySearch + " = " + value);
		} else
			System.out.println("la chiave " +keySearch + " non trovata");
	
		value = "v8";
		if (map.containsValue(value)) 
			System.out.println("Valore " + value + " trovata");
		else
			System.out.println("Valore " + value + " NON trovata");
		
		System.out.println("element k6:" + map.get("k6"));
		map.put("k6", "new value");
		System.out.println("element k6 after update:" + map.get("k6"));
		
		System.out.println("List map with Entry");
		for (Entry<String, String> it:map.entrySet()){
			System.out.println("key:" + it.getKey() + " valore;" + it.getValue());
		}

		System.out.println("List map with KeySet");
		for (String it:map.keySet()) {
			System.out.println("key :" + it + " value:" + map.get(it));
		}
		
		mapTest();
		mapTest1();
		return false;
	}
	
	private void mapTest() {
		String params = "p1=aaaa , p2 = bbb, p3= 24, p4=Paolo";
		String[] p = params.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String it:p) {
			String[] elem = it.split("=");
			map.put(elem[0].trim(),elem[1].trim());
		}
		System.out.println("Result param transformato in map:");
		for (String it:map.keySet()) {
			System.out.println("key:" + it + " value:" + map.get(it));
		}
	}
	private void mapTest1() {
		List<String> input = new ArrayList<String>();
		input.add("p1=aaaa , p2 = bbb, p3= 24, p4=Paolo");
		input.add("par1=10 , par2 = param2, par3= 54");
		input.add("k1=primo , k2 = secondo, k3= terzo");
		input.add("id=10 ,nome= pippo, cognome= verde");
		
		List<Map<String, String>> res = new ArrayList<Map<String, String>>();
		
		for (String inp:input) {
			String[] par1 = inp.split(",");
			Map<String, String> colum = new HashMap<String, String>();
			for (String it:par1) {
				String[] elem = it.split("=");
				colum.put(elem[0].trim(),elem[1].trim());
			}
			res.add(colum);
		}
		System.out.println("Risultato .....");
		int i = 0;
		for (Map<String,String> it:res) {
			System.out.println("riga " + ++i +" map size:" + it.size());
			for (String el:it.keySet()) {
				System.out.println("key:" + el + " value:" + it.get(el));
			}		
		}
		
	}
	private Map<String, String> createMap(){
		Map<String, String> map = new HashMap<String,String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "v10");
		
		return map;
	}

}
