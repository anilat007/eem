package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.DocumentSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class DocumentsService extends Repository<DocumentSO> {
	static Logger logger = Logger.getLogger(DocumentsService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<DocumentSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<DocumentSO> items = new ArrayList<DocumentSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.DOCUMENTS_MASTER.SEARCH_ALL
				: String.format(
						StudentAdmission.DOCUMENTS_MASTER.SEARCH_BY_NAME, name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					DocumentSO item = new DocumentSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					item.setRemarks(rs.getString(3));
					items.add(item);
				}
			}
		});
		return items;
	}

	@Override
	public List<DocumentSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<DocumentSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public DocumentSO Add(final DocumentSO item) throws DBException,
			Exception {
		dbHelper.ExecuteInsertWithSequence(
				StudentAdmission.DOCUMENTS_MASTER.SEQ,
				StudentAdmission.DOCUMENTS_MASTER.INSERT,
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
						ps.setString(3, item.getRemarks());
						ps.setString(4, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public DocumentSO Update(final DocumentSO item) throws DBException,
			Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.DOCUMENTS_MASTER.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, item.getName().trim());
						ps.setString(2, item.getRemarks());
						ps.setString(3, item.getUserId());
						ps.setInt(4, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {
		return dbHelper.ExeucteDeleteIDs(
				StudentAdmission.DOCUMENTS_MASTER.DELETE, ids);
	}
}
