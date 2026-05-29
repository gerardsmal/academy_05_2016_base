package com.betacom.services;

import com.betacom.dao.ClientiDAO;
import com.betacom.objects.Cliente;
import com.betacom.singleton.SqlConfigation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceUpdate {
	
	private ClientiDAO dao = new ClientiDAO();
	
	public void executeUpdate() {
		log.info("Begin serviceUpdate");
		SqlConfigation.getIntance().setAutocommit();
		int pk = insertClient();
		int rc = updateCliente(pk);
		rc = deleteCliente(pk);
	}
	
	private int insertClient() {
		log.debug("Insert nuovo cliente");
		int rc = 0;
		Cliente cli = Cliente.builder()
				.denominazione("Nuovo cliente srl")
				.pIva("109283837")
				.indirizzo("via dell'insert 12 suza")
				.telefono("11222333")
				.build();
		
		try {
			rc = dao.insert("update.clienti.insert", cli);
			log.debug("Insert nuovo cliente {}",rc);
	
		} catch (Exception e) {
			log.error("error nel insert cliente {}", e.getMessage());
		}
				
		return rc;		
	}
	
	public int updateCliente(int pk) {
		log.debug("update cliente {}", pk);
		int rc = 0;
		Cliente cli = new Cliente();
		cli.setIdCliento(pk);
		cli.setDenominazione("Updated srl");
		cli.setTelefono("99991233");
		try {
			rc = dao.update("update.clienti.update", cli);
			log.debug("cliente {} is updated rows updated: {}",pk,rc);
	
		} catch (Exception e) {
			log.error("error nel insert cliente {}", e.getMessage());
		}
				
		return rc;		
	}
	
	public int deleteCliente(int pk) {
		log.debug("update cliente {}", pk);
		int rc = 0;
		try {
			rc = dao.delete(pk);
			log.debug("cliente {} is deleted rows deleted:{}",pk,rc);
	
		} catch (Exception e) {
			log.error("error nel insert cliente {}", e.getMessage());
		}
				
		return rc;		

	}
}
