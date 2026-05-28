package com.betacom.utils;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.exception.AcademyException;
import com.betacom.singleton.SqlConfigation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GestioneSQL {

	/*
	 * ELenco tabelle
	 */
	public List<String> tableList(){
		log.debug("table list for {}", SqlConfigation.getIntance().retrieveDBName());
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = SqlConfigation.getIntance().getConnection().getMetaData();
			ResultSet res = dbMD.getTables(SqlConfigation.getIntance().retrieveDBName(), null, null, null);
			while (res.next()) {
				lT.add(res.getString("TABLE_name"));			
			}			
		} catch (SQLException e) {
			log.error("Error in tableList: {}", e.getMessage());
		}
		return lT;
	}
	
	/*
	 * query without parameters
	 */
	public List<Map<String,Object>> list(String query) throws AcademyException{
		try {
			PreparedStatement cmd = SqlConfigation.getIntance().getConnection().prepareStatement(query);
			
			ResultSet res = cmd.executeQuery();
			log.debug("After resulSet");
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		}
	}

	
	
	/*
	 * transform resultset in list map
	 */
	private List<Map<String,Object>> resultsetToList(ResultSet rs) throws SQLException{
		ResultSetMetaData mD = rs.getMetaData();   // retrieve resultset metadata
		int columns = mD.getColumnCount();         // retrieve columns number
		
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		while (rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>();
			for (int i=1; i <= columns; i++) {
				row.put(mD.getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
			
		}
		return rows;
		
	}
	
}
