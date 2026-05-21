package com.betacom.objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder 
@ToString (callSuper = true)
public class ObjectFiglio extends ObjectPadre{
	private String indirizzo;
	private String citta;
}
