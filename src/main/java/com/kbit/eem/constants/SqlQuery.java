package com.kbit.eem.constants;

import com.kbit.eem.utils.Helper;

public class SqlQuery {
	public static final String SYSDATE = "SYSDATE";
	public static final String SYSDATE_LONG = "TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:mm:ss')";

	public static String getSelect(String tableName) {
		return "SELECT * FROM " + tableName;
	}

	public static String getSelect(String tableName, String[] columns) {
		return "SELECT " + Helper.arrayToCsv(columns) + " FROM " + tableName;
	}

	public static String getSelect(String tableName, String condition) {
		return getSelect(tableName) + " WHERE " + condition;
	}

	public static String getSelect(String tableName, String[] columns,
			String condition) {
		return getSelect(tableName, columns) + " WHERE " + condition;
	}

	public static String getDelete(String tableName, String condition) {
		return "DELETE FROM " + tableName + " WHERE " + condition;
	}

	public static String getInsert(String tableName, String[] columns,
			String[] values) {
		StringBuilder query = new StringBuilder("INSERT INTO " + tableName);
		query.append(" (" + Helper.arrayToCsv(columns) + ")");
		query.append(" VALUES(" + Helper.arrayToCsv(values) + ")");
		return query.toString();
	}

	public static String getUpdate(String tableName, String setStatement,
			String condition) {
		StringBuilder query = new StringBuilder("UPDATE  " + tableName);
		query.append(" SET " + setStatement);
		query.append(" WHERE " + condition);
		return query.toString();
	}

	public static String getNextSeq(String sequence) {
		return "SELECT " + sequence + ".NEXTVAL FROM DUAL";
	}
}
