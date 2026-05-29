package com.betacom.services;

import java.util.List;
import java.util.Map;

import com.betacom.dao.DipendentiDAO;
import com.betacom.exception.AcademyException;
import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceQuery {
	
	private GestioneSQL db = new GestioneSQL();
	private DipendentiDAO dao = new DipendentiDAO();
	
	public void executeQuery() {
		log.info("ExecuteQuery ...");
		listAllTable();
		getAllDipendenti();
		getDipendentiWithParameters("impiegato", 4);
		getDependentiById(5);
		getCount("query.dipendenti");
		getCount("query.dipendenti_manzione_ufficio", "impiegato", 4);
	}
	/*
	 * database table list
	 */
	private void listAllTable() {
		List<String> tN =  db.tableList();
		tN.forEach(t -> log.debug("table : {}", t));		
	}
	/*
	 * query without parameter
	 */
	private void getAllDipendenti() {
		log.debug("getAllDipendenti****: {}", SqlConfigation.getIntance().getQuery("query.dipendenti") );
		try {
			List<Dipendenti>  lD =   dao.findAll();
			lD.forEach(d -> log.debug(d.toString()));
			
			
		} catch (Exception e) {
			log.error("error getAllDipendenti {}", e.getMessage());
		}
	}
	/*
	 * query with parameters
	 */
	private void getDipendentiWithParameters(String mansione, Integer ufficio)  {
		log.debug("getDipendentiWithParameters****: {}", SqlConfigation.getIntance().getQuery("query.dipendenti_manzione_ufficio") );
		try {
			List<Dipendenti> lD = dao.findGeneric("query.dipendenti_manzione_ufficio", new Object[] {mansione, ufficio});
			lD.forEach(d -> log.debug(d.toString()));			
			
		} catch (Exception e) {
			log.error("error getDipendentiWithParameters {}", e.getMessage());		}
		
	}
	/*
	 * query with single result
	 */
	private void getDependentiById(Integer id) {
		log.debug("getDependentiById****: {}", SqlConfigation.getIntance().getQuery("query.dipendenti_byId") );

		try {
			Dipendenti d = dao.findById(id)
					.orElseThrow(() -> new AcademyException("id non tovato in db :" + id));
			log.debug(d.toString());			
			
		} catch (Exception e) {
			log.error("error getDipendentiWithParameters {}", e.getMessage());		}

	}
	
	private void getCount(String query) {
		log.debug("getCount****: {}", SqlConfigation.getIntance().getQuery(query) );
		try {
			log.debug("count trovato {}", dao.count(query));
			
		} catch (Exception e) {
			log.error("error getDipendentiWithParameters {}", e.getMessage());		}		
		
	}
	private void getCount(String query, String mansione, Integer ufficio) {
		log.debug("getCount****: {}", SqlConfigation.getIntance().getQuery(query) );
		try {
			log.debug("count con paramteri trovato  {}", dao.count(query, new Object[] {mansione, ufficio}));
			
		} catch (Exception e) {
			log.error("error getDipendentiWithParameters {}", e.getMessage());		}		
		
	}
	
}
