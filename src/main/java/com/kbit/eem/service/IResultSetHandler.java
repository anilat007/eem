package com.kbit.eem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultSetHandler {
	void process(ResultSet rs) throws SQLException;
}