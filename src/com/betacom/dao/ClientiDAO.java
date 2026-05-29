package com.betacom.dao;

import java.util.ArrayList;
import java.util.List;

import com.betacom.exception.AcademyException;
import com.betacom.objects.Cliente;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientiDAO {
	
	private GestioneSQL db = new GestioneSQL();
	
	public int insert(String queryName, Cliente cli) throws Exception{
		
		Object[] parms = new Object[] {
			cli.getDenominazione(),
			cli.getPIva(),
			cli.getIndirizzo(),
			cli.getTelefono()
		};
		
		String query = SqlConfigation.getIntance().getQuery(queryName);
		
		return db.save(query, parms, true);
	}
	
	public int update(String queryName, Cliente cli) throws Exception{
		if (cli.getIdCliento() == null)
			throw new AcademyException("primay key non caricata per un update");
		
		StringBuilder query = new StringBuilder("UPDATE clienti SET ");
		List<Object> params = new ArrayList<>();
		List<String> fields = new ArrayList<>();

		if (cli.getDenominazione() != null) {
		    fields.add("denominazione = ?");
		    params.add(cli.getDenominazione());
		}

		if (cli.getPIva() != null) {
		    fields.add("p_iva = ?");
		    params.add(cli.getPIva());
		}

		if (cli.getIndirizzo() != null) {
		    fields.add("indirizzo = ?");
		    params.add(cli.getIndirizzo());
		}

		if (cli.getTelefono() != null) {
		    fields.add("telefono = ?");
		    params.add(cli.getTelefono());
		}

		if (fields.isEmpty()) {
		    throw new AcademyException("Nessun campo da aggiornare");
		}

		query.append(String.join(", ", fields));
		query.append(" ");
		query.append(SqlConfigation.getIntance().getQuery(queryName));
		params.add(cli.getIdCliento());  // store primary key
		
		Object[] paramsFinal = params.toArray();
				
		log.debug("SQL generata : {}", query.toString());
		
		return db.save(query.toString(), paramsFinal, false);
	}
	
	public int delete(Integer id) throws Exception{
		if (id == null)
			throw new AcademyException("Id non caricata");
		
		Object[] params = new Object[] {id};
		
		String query = "delete from clienti where id_cliento = ?";
		return db.save(query, params, false);
	}

}
