package com.betacom.process;

import java.util.StringTokenizer;

import com.betacom.interfaces.GeneralProcess;

public class StringManager implements GeneralProcess{

	@Override
	public boolean execute() {
		System.out.println("Begin StringManager");
		
		String nome = "Gérard";
		
		StringBuilder sb = new StringBuilder();
		sb.append("Buongiorno");
		sb.append(", ");
		sb.append("sono ");
		sb.append(nome);
		
		String res = sb.toString();
		System.out.println(res);
		
		
		/*
		 * String format
		 */
		String n = "francese";
		res = String.format("Mio nome é %s, e sono %s", nome, n);
		
		System.out.println(res);
		
		if ("gerard".equalsIgnoreCase(nome))
			System.out.println("Found..");
		
		if (res.contains("sono"))
			System.out.println("trovato la string sono");
		else
			System.out.println("String non trovata");
		
		String text = "    ".trim();
		if (text.isEmpty())
			System.out.println("Text é vuoto");
		
		/*
		 * String compare
		 */
		String p1 = "Samsung";
		String p2 = "Samsu11";
		int result = p2.compareTo(p1);
		
		System.out.println("compare :" + result);
		
		/*
		 * transform integer to string
		 */
		result = 20;
		String numeroStr = String.valueOf(result);
		System.out.println("Valore di numeroStr:" + numeroStr);
		
		result = Integer.parseInt(numeroStr);
		
		/*
		 * transformazione d'una string in array
		 */
		String parameters = "token1,token2, token3 , token4  , token5 , token6";
		String[] tokens = parameters.split(",");
		for (String it:tokens) {
			System.out.println(">>" +it.trim() + "<<");
		}
		
		/*
		 * StringTokenizer
		 */
		StringTokenizer st = new StringTokenizer(parameters, ",");
		while (st.hasMoreElements()) {
			String txt = st.nextToken().trim();
			System.out.println(">>" +txt + "<<");

		}
		/*
		 * Substring
		 */
		System.out.println(res.substring(res.indexOf("G")));
		System.out.println(res.substring(res.indexOf("G"), res.indexOf(",")));
	
		
		String prova = "   questa é un test per ££ , vediamo il risultato in ££";
		String provaR = prova.replaceAll("££", "Java").trim();
		System.out.println(provaR);
		 
		
		return false;
	}

}
