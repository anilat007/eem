package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.ReligionSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class ReligionService extends Repository<ReligionSO> {
	static Logger logger = Logger.getLogger(ReligionService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<ReligionSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<ReligionSO> items = new ArrayList<ReligionSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.RELIGION_DETAILS.SEARCH_ALL
				: String.format(
						StudentAdmission.RELIGION_DETAILS.SEARCH_BY_NAME, name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					ReligionSO item = new ReligionSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					items.add(item);
				}
			}
		});
		return items;
	}

	public static List<ReligionSO> Get_Items() throws DBException, Exception {
		return (new ReligionService().GetItems());
	}
	
	@Override
	public List<ReligionSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<ReligionSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public ReligionSO Add(final ReligionSO item) throws DBException, Exception {
		dbHelper.ExecuteInsertWithSequence(
				StudentAdmission.RELIGION_DETAILS.SEQ,
				StudentAdmission.RELIGION_DETAILS.INSERT,
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
	public ReligionSO Update(final ReligionSO item) throws DBException,
			Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.RELIGION_DETAILS.UPDATE,
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
				StudentAdmission.RELIGION_DETAILS.DELETE, ids);
	}
}