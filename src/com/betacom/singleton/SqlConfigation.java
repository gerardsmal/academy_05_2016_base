package com.betacom.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.betacom.exception.AcademyException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SqlConfigation {
	
	private static  SqlConfigation instance = null;
	private static  Properties prop = new Properties();
	private static  Properties queries = new Properties();
	
	private Connection conn = null;
	
	private SqlConfigation() {}
	
	public static SqlConfigation getIntance() {
		if (instance == null) {
			instance = new SqlConfigation();
			loadConfiguration();
		}
		return instance;
	}
	
	private static void loadConfiguration() {
		
		try {
			InputStream input = new FileInputStream("src/sql.properties");
			prop.load(input);
			
			input = new FileInputStream("src/queries.properties");
			queries.load(input);
			
		} catch (IOException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	private String getProperty(String p) {
		return prop.getProperty(p);
	}
	public String retrieveDBName() {
		String url = getProperty("url");
		return url.substring(url.lastIndexOf("/") + 1);
	}
	public String getQuery(String p) {
		return queries.getProperty(p);
	}
	
	public Connection getConnection() throws AcademyException {
		if (conn == null )
			conn = openConnection();
		return conn;
	}
	
	/*
	 * close connection
	 */
	public void closeConnection() throws AcademyException {
		try {
			if (conn != null)
				conn.close();
			conn = null;
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	private Connection openConnection() throws AcademyException {
		try {
			Class.forName(getProperty("driver"));
			return DriverManager.getConnection(
					getProperty("url"),
					getProperty("user"),
					getProperty("pwd"));					
			
		} catch (Exception e) {
			throw new AcademyException("Errore nella connessione:" + e.getMessage());
		}
	}
	
	public void setAutocommit() throws AcademyException {
		try {
			if (conn == null)
				throw new AcademyException("non abbiamo connessione attive");
			conn.setAutoCommit(true);   // autocommit is setted			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}		
	}
	
	public void setTransaction() throws AcademyException {
		try {
			if (conn == null)
				throw new AcademyException("non abbiamo connessione attive");
			conn.setAutoCommit(false);   // autocommit is setted			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}		
	}
	
	public void commit() {
		try {
			if (conn == null)
				throw new AcademyException("non abbiamo connessione attive");
			conn.commit(); 			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}		
		
	}

	public void rollback() {
		try {
			if (conn == null)
				throw new AcademyException("non abbiamo connessione attive");
			conn.rollback();  			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}		
		
	}
	
	
}
