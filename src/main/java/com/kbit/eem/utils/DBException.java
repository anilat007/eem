package com.kbit.eem.utils;

import java.sql.SQLException;

public class DBException extends Exception {
	SQLException sqlException;
	private static final long serialVersionUID = 1L;

	public DBException(SQLException sqlException) {
		this.sqlException = sqlException;
	}
}
