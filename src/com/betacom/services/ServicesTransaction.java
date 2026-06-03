package com.betacom.services;

import java.time.LocalDate;

import com.betacom.dao.ClientiDAO;
import com.betacom.dao.DipendentiDAO;
import com.betacom.dao.RapportoClientDAO;
import com.betacom.objects.Cliente;
import com.betacom.objects.Dipendenti;
import com.betacom.objects.RapportoCliente;
import com.betacom.singleton.SqlConfigation;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServicesTransaction {

	private final DipendentiDAO     daoD;
	private final ClientiDAO        daoC;
	private final RapportoClientDAO daoR;
	
	
	public ServicesTransaction(){
		this.daoD = new DipendentiDAO();
		this.daoC = new ClientiDAO();
		this.daoR = new RapportoClientDAO();
	}
	
	public void executeTransaction() {
		log.info("Begin executeTransaction ********");
		try {
			SqlConfigation.getIntance().setTransaction();
			Dipendenti dip = Dipendenti.builder()
					.nome("Alice")
					.cognome("Blueta")
					.dataAssunzione(LocalDate.of(2001, 05, 26))
					.mansione("immpiegato")
					.stipendio(1800.0)
					.idUfficio(4)
					.code("A944")
					.telefono("2345612")
					.build();
			
			int idDip = daoD.insert("update.dipendenti.insert", dip);
			log.debug("Dipendente created :{}", idDip);
			
			Cliente cli = Cliente.builder()
					.denominazione("Transaction SRL")
					.pIva("2143546565")
					.indirizzo("via lattea 12 Sestriere")
					.telefono("98346537")					
					.build();
			int idCli = daoC.insert("update.clienti.insert", cli);
			log.debug("Cliente created :{}", idCli);
			
			RapportoCliente rap = RapportoCliente.builder()
					.descrizione("rapporto transaction")
					.idCliente(idCli)
					.idDipendente(idDip)
					.prova(1)
					.build();
			
			int idRap= daoR.insert("update.rapportiCliente.insert", rap);
			
			log.debug("Rapporto cliente created :{}", idRap);
			
			log.debug("numero righe cancellate per rapporto cliente {}", daoR.delete(idRap));
			log.debug("numero righe cancellate per cliente {}", daoC.delete(idCli));
			log.debug("numero righe cancellate per Dipendenti {}", daoD.delete(idDip));

//			int i = 0;
//			idDip = idDip / i;
			
			SqlConfigation.getIntance().commit();
		} catch (Exception e) {
			log.error("error found {}", e.getMessage());
			SqlConfigation.getIntance().rollback();
			
		}
		
		
	}
	
}
