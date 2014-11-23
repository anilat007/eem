package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.SchemSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class SchemeService extends Repository<SchemSO> {
	static Logger logger = Logger.getLogger(SchemeService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<SchemSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<SchemSO> items = new ArrayList<SchemSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.SCHEME_MASTER.SEARCH_ALL
				: String.format(StudentAdmission.SCHEME_MASTER.SEARCH_BY_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					SchemSO item = new SchemSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					item.setStatus(rs.getString(3));
					items.add(item);
				}
			}
		});
		return items;
	}
	
	public static List<SchemSO> Get_Items() throws DBException, Exception {
		return (new SchemeService().GetItems());
	}

	@Override
	public List<SchemSO> GetItemsBy(Object name) throws DBException, Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<SchemSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public SchemSO Add(final SchemSO item) throws DBException, Exception {
		dbHelper.ExecuteInsertWithSequence(StudentAdmission.SCHEME_MASTER.SEQ,
				StudentAdmission.SCHEME_MASTER.INSERT,
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
						//ps.setString(3, item.getStatus());
						ps.setString(3, StudentAdmission.SCHEME_MASTER.SCHEME_NEXT);
						ps.setString(4, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public SchemSO Update(final SchemSO item) throws DBException, Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.SCHEME_MASTER.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, item.getName().trim());
						//ps.setString(1, item.getStatus().trim());
						ps.setString(2, item.getUserId());
						ps.setInt(3, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {
		return dbHelper.ExeucteDeleteIDs(
				StudentAdmission.SCHEME_MASTER.DELETE, ids);
	}
}