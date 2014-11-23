package com.kbit.eem.service.Configurations.Receipt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.Receipt;
import com.kbit.eem.models.service.Configurations.Receipt.HeadAccountSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class HeadAccountService extends Repository<HeadAccountSO> {
	static Logger logger = Logger.getLogger(HeadAccountService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<HeadAccountSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<HeadAccountSO> items = new ArrayList<HeadAccountSO>();
		String query = (name == null || name.trim().equals("")) ? Receipt.HEAD_ACCOUNT_MASTER.SEARCH_ALL
				: String.format(
						Receipt.HEAD_ACCOUNT_MASTER.SEARCH_BY_HEAD_ACCOUNT_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					HeadAccountSO item = new HeadAccountSO();
					item.setId(rs.getInt(1));
					item.setAccountNumber(rs.getString(2));
					item.setAccountName(rs.getString(3));
					items.add(item);
				}
			}
		});
		return items;
	}

	@Override
	public List<HeadAccountSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<HeadAccountSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public HeadAccountSO Add(final HeadAccountSO item) throws DBException,
			Exception {

		dbHelper.ExecuteInsertWithSequence(Receipt.HEAD_ACCOUNT_MASTER.SEQ,
				Receipt.HEAD_ACCOUNT_MASTER.INSERT,
				new IResultSetHandler() {
					@Override
					public void process(ResultSet rs) throws SQLException {
						if (rs.next()) {
							item.setId(rs.getInt(1));
						}
					}
				}, new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, item.getId());
						ps.setString(2, item.getAccountNumber().trim());
						ps.setString(3, item.getAccountName().trim());
						ps.setString(4, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public HeadAccountSO Update(final HeadAccountSO item) throws DBException,
			Exception {

		dbHelper.ExecuteUpdate(Receipt.HEAD_ACCOUNT_MASTER.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, item.getAccountNumber().trim());
						ps.setString(2, item.getAccountName().trim());
						ps.setString(3, item.getUserId());
						ps.setInt(4, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {

		return dbHelper.ExeucteDeleteIDs(
				Receipt.HEAD_ACCOUNT_MASTER.DELETE, ids);
	}
}