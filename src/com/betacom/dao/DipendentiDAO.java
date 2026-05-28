package com.betacom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;
import com.betacom.utils.Utilities;

public class DipendentiDAO {
	private GestioneSQL db = new GestioneSQL();
	
	public List<Dipendenti> findAll() throws Exception{
		
		List<Map<String,Object>> r = db.list(SqlConfigation.getIntance().getQuery("query.dipendenti"));
		
		return r.stream()
				.map (d -> Dipendenti.builder()
						.idDipendente((Integer)d.get("id_dipendente"))
						.nome(d.get("nome").toString())
						.cognome(d.get("cognome").toString())
						.dataAssunzione(Utilities.dateToLocalDate(d.get("data_assunzione")))
						.telefono(d.get("telefono").toString())
						.mansione(d.get("mansione").toString())
						.stipendio(((BigDecimal)d.get("stipendio")).doubleValue())
						.idUfficio((Integer)d.get("id_ufficio"))
						.code(d.get("code").toString())
						.build()
						).toList();
		
	}
}
