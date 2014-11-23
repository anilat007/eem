package com.kbit.eem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;

public class DBHelper {
	DBManager dbManager = DBManager.getInstance();
	Logger logger;
	
	public DBHelper(){
		this(Logger.getLogger(DBHelper.class));
	}
	
	public DBHelper(Logger logger){
		this.logger = logger;
	}
	
	public void ExeucteGet(String query, IResultSetHandler rsHandler) throws DBException, Exception{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dbManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			rsHandler.process(resultSet);
		}catch (SQLException e){
			e.printStackTrace();
			Helper.logError(logger, e);
			throw new DBException(e);
		} catch (Exception e) {
			e.printStackTrace();
			Helper.logError(logger, e);
			throw e;
		} finally {
			dbManager.closeConnection();
		}
	}
	
	public int ExecuteInsertWithSequence (String sequenceQuery, String insertQuery, IResultSetHandler sequenceRSHandler, IPreparedStatementHandler psHandler) throws DBException, Exception{
		int count = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dbManager.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sequenceQuery);
			sequenceRSHandler.process(resultSet);
			preparedStatement = connection.prepareStatement(insertQuery);
			psHandler.process(preparedStatement);
			count = preparedStatement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			Helper.logError(logger, e);
			throw new DBException(e);
		} catch (Exception e) {
			e.printStackTrace();
			Helper.logError(logger, e);
			throw e;
		} finally {
			dbManager.closeConnection();
		}
		return count;
	}
	
	public int ExeucteDeleteIDs(String query, int[] ids) throws DBException, Exception{
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dbManager.getConnection();
			String _query = String.format(query, Helper.arrayToCsv(ids));
			preparedStatement = connection.prepareStatement(_query);
			count = preparedStatement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			Helper.logError(logger, e);
			throw new DBException(e);
		} catch (Exception e) {
			e.printStackTrace();
			Helper.logError(logger, e);
			throw e;
		} finally {
			dbManager.closeConnection();
		}
		return count;
	}
	
	public int ExecuteUpdate(String query, IPreparedStatementHandler psHandler) throws DBException, Exception{
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dbManager.getConnection();
			preparedStatement = connection.prepareStatement(query);
			psHandler.process(preparedStatement);
			count = preparedStatement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			Helper.logError(logger, e);
			throw new DBException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
			Helper.logError(logger, e);
		} finally {
			dbManager.closeConnection();
		}
		return count;
	}
}