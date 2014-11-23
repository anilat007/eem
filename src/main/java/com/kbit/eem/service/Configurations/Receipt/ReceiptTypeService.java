package com.kbit.eem.service.Configurations.Receipt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.Receipt;
import com.kbit.eem.models.service.Configurations.Receipt.ReceiptTypeSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.Receipt.ReceiptTypeService;
import com.kbit.eem.utils.DBException;

public class ReceiptTypeService extends Repository<ReceiptTypeSO> {
	static Logger logger = Logger.getLogger(ReceiptTypeService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<ReceiptTypeSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<ReceiptTypeSO> items = new ArrayList<ReceiptTypeSO>();
		String query = (name == null || name.trim().equals("")) ? Receipt.FEE_RECEIPT_TYPE_MASTER.SEARCH_ALL
				: String.format(
						Receipt.FEE_RECEIPT_TYPE_MASTER.SEARCH_BY_RECEIPT_TYPE_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					ReceiptTypeSO item = new ReceiptTypeSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					items.add(item);
				}
			}
		});
		return items;
	}

	@Override
	public List<ReceiptTypeSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<ReceiptTypeSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public ReceiptTypeSO Add(final ReceiptTypeSO item) throws DBException,
			Exception {

		dbHelper.ExecuteInsertWithSequence(Receipt.FEE_RECEIPT_TYPE_MASTER.SEQ,
				Receipt.FEE_RECEIPT_TYPE_MASTER.INSERT,
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
						ps.setString(2, item.getName().trim());
						ps.setString(3, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public ReceiptTypeSO Update(final ReceiptTypeSO item) throws DBException,
			Exception {

		dbHelper.ExecuteUpdate(Receipt.FEE_RECEIPT_TYPE_MASTER.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, item.getName().trim());
						ps.setString(2, item.getUserId());
						ps.setInt(3, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {

		return dbHelper.ExeucteDeleteIDs(
				Receipt.FEE_RECEIPT_TYPE_MASTER.DELETE, ids);
	}
}