package com.kbit.eem.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IPreparedStatementHandler {
	void process(PreparedStatement ps) throws SQLException;
}