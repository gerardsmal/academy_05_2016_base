package com.betacom.process;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.services.ServiceQuery;
import com.betacom.singleton.SqlConfigation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.info("Begin process SQL");
		try {
			SqlConfigation.getIntance().getConnection();
			log.debug("Connect database ok");
			new ServiceQuery().executeQuery();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		
		return false;
	}

}
