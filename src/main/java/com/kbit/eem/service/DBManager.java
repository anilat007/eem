package com.kbit.eem.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public final class DBManager {
	static Logger logger = Logger.getLogger(DBManager.class);	
	private static String DATASOURCENAME = "java:/bis";
	private static DataSource _globalDataSource = null;
	
	private Connection connection;
	private Statement stmt;

	static {
		try {
			InitialContext context = new InitialContext();
			_globalDataSource = (DataSource) context.lookup(DATASOURCENAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance(){
		return new DBManager();
	}
	
	private DBManager(){
		
	}
	
	public Connection getConnection() {
		Connection conn = null;
		if (this.connection != null) {
			conn = this.connection;
		} else {
			this.openConnection();
			conn = this.connection;
		}
		return conn;
	}

	private void openConnection() {
		try {
			connection = _globalDataSource.getConnection();
			stmt = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			logger.info("_globalDataSource " + _globalDataSource);
			logger.info("Conenction obtained " + connection);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		} finally {
		}		
	}

	public void closeConnection() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
			}
			stmt = null;
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception ex) {
			}
			connection = null;
		}	
	}	
}