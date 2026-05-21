package com.betacom.objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@ToString
public abstract  class ObjectPadre {
	private String nome;
	private String cognome;
	private boolean sesso;
}
