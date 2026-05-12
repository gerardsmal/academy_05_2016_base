package com.betacom.objects;

public class Impiegato extends User{
	
	private double salary;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Impiegato [salary=" + salary  + ", getNome()=" + getNome()
				+ ", getCognome()=" + getCognome() + ", getSesso()=" + getSesso() + "]";
	}
	

}
