package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.StateSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class StateService extends Repository<StateSO> {
	static Logger logger = Logger.getLogger(StateService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<StateSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<StateSO> items = new ArrayList<StateSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.STATE_DETAILS.SEARCH_ALL
				: String.format(StudentAdmission.STATE_DETAILS.SEARCH_BY_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					StateSO item = new StateSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					items.add(item);
				}
			}
		});
		return items;
	}
	
	public static List<StateSO> Get_Items() throws DBException, Exception {
		return new StateService().GetItems("");
	}

	@Override
	public List<StateSO> GetItemsBy(Object name) throws DBException, Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<StateSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public StateSO Add(final StateSO item) throws DBException, Exception {
		dbHelper.ExecuteInsertWithSequence(StudentAdmission.STATE_DETAILS.SEQ,
				StudentAdmission.STATE_DETAILS.INSERT, new IResultSetHandler() {
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
	public StateSO Update(final StateSO item) throws DBException, Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.STATE_DETAILS.UPDATE,
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
		return dbHelper.ExeucteDeleteIDs(StudentAdmission.STATE_DETAILS.DELETE,
				ids);
	}
}