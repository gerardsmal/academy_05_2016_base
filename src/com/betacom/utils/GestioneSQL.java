package com.betacom.utils;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
	 * query with parameters
	 */
	public List<Map<String,Object>> list(String query, Object[] params) throws AcademyException{
		try {
			PreparedStatement cmd = SqlConfigation.getIntance().getConnection().prepareStatement(query); // compile query
			cmd = createset(cmd, params); // load parameters into preparedStatement
			
			ResultSet res = cmd.executeQuery();
			log.debug("After resulSet");
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		}
	}
	
	/*
	 * query with single result object
	 */
	public Map<String,Object> get(String query, Object[] params) throws AcademyException{
		try {
			PreparedStatement cmd = SqlConfigation.getIntance().getConnection().prepareStatement(query); // compile query
			cmd = createset(cmd, params); // load parameters into preparedStatement
			
			ResultSet res = cmd.executeQuery();
			return resultsetToMap(res);
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		}
	}
	
	/*
	 * count without parameter
	 */
	public Long count(String query) throws Exception{
		try {
			String queryCount = "select count(*) as numero from (" + query + ") as numero";			
			PreparedStatement cmd = SqlConfigation.getIntance().getConnection().prepareStatement(queryCount); // compile query			
			ResultSet res = cmd.executeQuery();
			
			res.next();		
			return res.getLong("numero");
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		}
		
	}
	/*
	 * count with parameters
	 */
	public Long count(String query, Object[] params) throws Exception{
		try {
			String queryCount = "select count(*) as numero from (" + query + ") as numero";
			
			PreparedStatement cmd = SqlConfigation.getIntance().getConnection().prepareStatement(queryCount); // compile query
			cmd = createset(cmd, params); // load parameters into preparedStatement
			ResultSet res = cmd.executeQuery();
			
			res.next();			
			return res.getLong("numero");
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		}
		
	}
	
	/*
	 * insert pk = true return primary key 
	 * 			   false return number of rows inserted o updated
	 */
	public int save(String query, Object[] params, boolean pk) throws AcademyException{
		int ret = 0;
		try {
			PreparedStatement cmd = null;
			if (pk)			
				cmd = SqlConfigation.getIntance().getConnection()
				.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);					
			else 
				cmd = SqlConfigation.getIntance().getConnection().prepareStatement(query);
			
			cmd = createset(cmd, params);

			ret = cmd.executeUpdate();
			
			/* retrieve generated key if necessary  */
			
			if (pk){
				ResultSet generatedKeys = cmd.getGeneratedKeys();
				if (generatedKeys.next())
					ret = generatedKeys.getInt(1);
			} 
			
		} catch (Exception e) {
			throw new AcademyException("List error :" + e.getMessage());
		} 
		
		return ret;
	}
	
	
	/*
	 * load parameters into PreparedStatement
	 */
	private PreparedStatement createset(PreparedStatement cmd, Object[] params) throws SQLException{
		createset(cmd, params, 0);
		return cmd;
	}	
	private void createset(PreparedStatement cmd, Object[] params, int index) throws SQLException{
		if (index >= params.length) return; // end of recursion
		cmd.setObject(index + 1, params [index]);
		createset(cmd, params, index + 1);
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
				row.put(mD.getColumnLabel(i), rs.getObject(i));
			}
			rows.add(row);
			
		}
		return rows;
		
	}

	/*
	 * transform resultset in  map
	 */
	private Map<String,Object> resultsetToMap(ResultSet rs) throws SQLException{
		ResultSetMetaData mD = rs.getMetaData();   // retrieve resultset metadata
		int columns = mD.getColumnCount();         // retrieve columns number
		
		if (!rs.next()) return null;  // no result
		
		Map<String, Object> row = new HashMap<String, Object>();
		for (int i=1; i <= columns; i++) {
			row.put(mD.getColumnLabel(i), rs.getObject(i));
			}
		return row;
		
	}

}
