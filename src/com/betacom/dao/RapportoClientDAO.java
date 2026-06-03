package com.betacom.dao;

import com.betacom.exception.AcademyException;
import com.betacom.objects.Dipendenti;
import com.betacom.objects.RapportoCliente;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RapportoClientDAO {

	private GestioneSQL db = new GestioneSQL();
	
	public int insert(String queryName, RapportoCliente rap) throws Exception{
		
		Object[] parms = new Object[] {
				rap.getDescrizione(),
				rap.getIdCliente(),
				rap.getIdDipendente(),
				rap.getProva()
		};
		
		String query = SqlConfigation.getIntance().getQuery(queryName);
		
		return db.save(query, parms, true);
	}
	
	public int delete(Integer id) throws Exception{
		if (id == null)
			throw new AcademyException("Id non caricata");
		
		Object[] params = new Object[] {id};
		
		String query = "delete from rapporto_cliente where id_rapporto = ?";
		return db.save(query, params, false);
	}

}
