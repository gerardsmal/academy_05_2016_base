package com.betacom.objects;

import com.betacom.enums.Reparto;

public class Impiegato extends User{
	
	private double salary;
	private Reparto reparto;

	public Impiegato() {
		super();
	}
	
	public Impiegato(String nome, String cognome, boolean sesso, double salary) {
		super(nome, cognome, sesso);
		this.salary = salary;
	}

	public Impiegato(String nome, String cognome, String sesso, double salary) {
		super(nome, cognome, sesso);
		this.salary = salary;
	}

	public Impiegato(String nome, String cognome, String sesso, double salary, String reparto) {
		super(nome, cognome, sesso);
		this.salary = salary;
		try {
			this.reparto = Reparto.valueOf(reparto);
		} catch (IllegalArgumentException e) {
			this.reparto = Reparto.IT;
			System.out.println("Reparto:" + this.reparto.toString());
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Reparto getReparto() {
		return reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		String rep = "";
		if (reparto != null) {
			rep = ", reparto= " + reparto.toString();
		}
		
		return "Impiegato [salary=" + salary  + ", getNome()=" + getNome()
				+ ", getCognome()=" + getCognome()  + rep  + ", getSesso()=" + getSesso() + "]";
	}


}
