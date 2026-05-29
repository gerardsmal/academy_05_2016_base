package com.betacom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;
import com.betacom.utils.Utilities;

public class DipendentiDAO {
	private GestioneSQL db = new GestioneSQL();
	
	public List<Dipendenti> findAll() throws Exception{	
		List<Map<String,Object>> r = db.list(SqlConfigation.getIntance().getQuery("query.dipendenti"));
		return buildDipendentiList(r);
		
	}
	
	public List<Dipendenti> findGeneric(String queryName, Object[] params) throws Exception{
		String query = SqlConfigation.getIntance().getQuery(queryName);
		List<Map<String,Object>> r = db.list(query,params);
		return buildDipendentiList(r);
	}
	
	public Optional<Dipendenti> findById(Integer id) throws Exception{
		String query = SqlConfigation.getIntance().getQuery("query.dipendenti_byId");
		Object[] param = new Object[] {id};
		
		Map<String,Object> d = db.get(query, param);
		
		if (d == null)
			return Optional.empty();
		
		return Optional.ofNullable(Dipendenti.builder()
				.idDipendente((Integer)d.get("id_dipendente"))
				.nome(d.get("nome").toString())
				.cognome(d.get("cognome").toString())
				.dataAssunzione(Utilities.dateToLocalDate(d.get("data_assunzione")))
				.telefono(d.get("telefono").toString())
				.mansione(d.get("mansione").toString())
				.stipendio(((BigDecimal)d.get("stipendio")).doubleValue())
				.idUfficio((Integer)d.get("id_ufficio"))
				.code(d.get("code").toString())
				.build());
	}
	
	
	public Long count(String queryName) throws Exception{
		String query = SqlConfigation.getIntance().getQuery(queryName);
		return db.count(query);
	}
	
	public Long count(String queryName, Object[] params) throws Exception{
		String query = SqlConfigation.getIntance().getQuery(queryName);
		return db.count(query, params);
	}
	
	
	
	
	private List<Dipendenti> buildDipendentiList(List<Map<String,Object>> r){
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
						).collect(Collectors.toList());
		
	}
}
