package com.betacom.process;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;
import com.betacom.utils.Utilities;

public class DateManager implements GeneralProcess{
	private final static String PATTERN_DATE = "d/M/yyyy";
	private final static String PATTERN_DATE_ESTESO = "E d/M/yyyy HH:mm:ss";

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin DateManager");
		
		LocalDateTime adesso = LocalDateTime.now();
		
		
		String r = String.format("Adesso siamo il %s", Utilities.dateToString(PATTERN_DATE, adesso));
		System.out.println(r);

		r = String.format("Adesso siamo il %s", Utilities.dateToString(PATTERN_DATE_ESTESO, adesso));
		System.out.println(r);

//		LocalDate birthday = Utilities.stringToDate(PATTERN_DATE, "10/05/1971");
//		
//		System.out.println(birthday);
		
		User usr = new User("Anna", "Labella", "F", Utilities.stringToDate(PATTERN_DATE, "10/05/1971"));
		System.out.println(usr);

		usr = new User("Gianni", "Laverdura", "M", 2000, 12, 12);
		System.out.println(usr);
		
		
		System.out.println("Data nascita :" + Utilities.dateToString(PATTERN_DATE, usr.getDataNascita()));
		
		int plusGiorni = 25;
		usr.setDataNascita(usr.getDataNascita().plusDays(plusGiorni));
		
		System.out.println("Data modificata :" + Utilities.dateToString(PATTERN_DATE, usr.getDataNascita()));
		

		usr.setCertificatoMedico(Utilities.stringToDate(PATTERN_DATE, "10/05/2025"));
		System.out.println(usr);
		
		int meseDiValidita = 12;
		LocalDate endDate = usr.getCertificatoMedico().plusMonths(meseDiValidita);
		
		if (LocalDate.now().isAfter(endDate))
			System.out.println("Certificato medico scaduto. date fine validita :" + 
						Utilities.dateToString(PATTERN_DATE, endDate));
		else 
			System.out.println("Certificato medico valido fino " + Utilities.dateToString(PATTERN_DATE, endDate));
		
		
		
		return false;
	}

}
