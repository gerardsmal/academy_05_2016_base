package com.betacom.objects;

public class User {
	private String nome;
	private String cognome;
	private Boolean sesso;
	
	public User() {
	}

	public User(String nome, String cognome, Boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}

	public User(String nome, String cognome, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = "M".equalsIgnoreCase(sesso) ? true : false;
	}

	 
	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Boolean getSesso() {
		return sesso;
	}

	public void setSesso(boolean sesso) {
		this.sesso = sesso;
	}
	
}
