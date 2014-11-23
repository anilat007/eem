package com.kbit.eem.service.Configurations;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
	T Get(int id) throws SQLException, Exception;
	T Add(T item) throws SQLException, Exception;
	T Update(T item) throws SQLException, Exception;
	void Remove(int id) throws SQLException, Exception;
	
	List<T> GetItems() throws SQLException, Exception;
	List<T> GetItemsBy(Object key) throws SQLException, Exception;
	List<T> GetItems(int[] ids) throws SQLException, Exception;
	List<T> Add(List<T> items) throws SQLException, Exception;
	List<T> Update(List<T> items) throws SQLException, Exception;
	int Remove(int[] ids) throws SQLException, Exception;
}
