package com.betacom.services;

import java.util.List;
import java.util.Map;

import com.betacom.dao.DipendentiDAO;
import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceQuery {
	
	private GestioneSQL db = new GestioneSQL();
	
	public void executeQuery() {
		log.info("ExecuteQuery ...");
		List<String> tN =  db.tableList();
		tN.forEach(t -> log.debug("table : {}", t));
		
		getAllDipendenti();
	}
	
	private void getAllDipendenti() {
		log.debug("getAllDipendenti****: {}", SqlConfigation.getIntance().getQuery("query.dipendenti") );
		DipendentiDAO dao = new DipendentiDAO();
		try {
			List<Dipendenti>  lD =   dao.findAll();
			lD.forEach(d -> log.debug(d.toString()));
			
			
		} catch (Exception e) {
			log.error("error getAllDipendenti {}", e.getMessage());
		}
			
		
	}
}
