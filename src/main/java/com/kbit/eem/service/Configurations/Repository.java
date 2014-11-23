package com.kbit.eem.service.Configurations;

import java.sql.SQLException;
import java.util.List;

import org.jboss.util.NotImplementedException;

public abstract class Repository<T> implements IRepository<T> {
	@Override
	public T Get(int id) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public T Add(T item) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public T Update(T item) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public void Remove(int id) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public List<T> GetItems() throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public List<T> GetItems(int[] ids) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public List<T> Add(List<T> items) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public List<T> Update(List<T> items) throws SQLException, Exception {
		throw new NotImplementedException();
	}

	@Override
	public int Remove(int[] ids) throws SQLException, Exception {
		throw new NotImplementedException();
	}
	
	@Override
	public List<T> GetItemsBy(Object key) throws SQLException, Exception {
		throw new NotImplementedException();
	}
}