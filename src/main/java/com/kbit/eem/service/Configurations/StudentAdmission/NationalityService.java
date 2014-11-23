package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.NationalitySO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class NationalityService extends Repository<NationalitySO> {
	static Logger logger = Logger.getLogger(NationalityService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<NationalitySO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<NationalitySO> items = new ArrayList<NationalitySO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.COUNTRY_DETAILS.SEARCH_ALL
				: String.format(
						StudentAdmission.COUNTRY_DETAILS.SEARCH_BY_NAME, name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					NationalitySO item = new NationalitySO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					items.add(item);
				}
			}
		});
		return items;
	}

	@Override
	public List<NationalitySO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<NationalitySO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public NationalitySO Add(final NationalitySO item) throws DBException,
			Exception {
		dbHelper.ExecuteInsertWithSequence(
				StudentAdmission.COUNTRY_DETAILS.SEQ,
				StudentAdmission.COUNTRY_DETAILS.INSERT,
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
	public NationalitySO Update(final NationalitySO item) throws DBException,
			Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.COUNTRY_DETAILS.UPDATE,
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
				StudentAdmission.COUNTRY_DETAILS.DELETE, ids);
	}
}
