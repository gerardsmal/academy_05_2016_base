package com.betacom.objects;

import java.time.LocalDate;

public class User {
	private String nome;
	private String cognome;
	private Boolean sesso;
	private LocalDate dataNascita;
	private LocalDate certificatoMedico;
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

	public User(String nome, String cognome, String sesso, LocalDate dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = "M".equalsIgnoreCase(sesso) ? true : false;
		this.dataNascita = dataNascita;
	}

	public User(String nome, String cognome, String sesso, int anno, int mese, int giorno) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = "M".equalsIgnoreCase(sesso) ? true : false;
		this.dataNascita = LocalDate.of(anno, mese, giorno);
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}


	public LocalDate getCertificatoMedico() {
		return certificatoMedico;
	}

	public void setCertificatoMedico(LocalDate certificatoMedico) {
		this.certificatoMedico = certificatoMedico;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", dataNascita=" + dataNascita
				+ ", certificatoMedico=" + certificatoMedico + "]";
	}

	
}
