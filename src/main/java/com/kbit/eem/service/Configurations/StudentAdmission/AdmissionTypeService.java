package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.AdmissionTypeSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class AdmissionTypeService extends Repository<AdmissionTypeSO> {
	static Logger logger = Logger.getLogger(AdmissionTypeService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<AdmissionTypeSO> GetItems(String name)
			throws DBException, Exception {
		final ArrayList<AdmissionTypeSO> items = new ArrayList<AdmissionTypeSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.STUDENT_ADMISSION_TYPE.SEARCH_ALL
				: String.format(
						StudentAdmission.STUDENT_ADMISSION_TYPE.SEARCH_BY_ADMISSION_TYPE_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					AdmissionTypeSO item = new AdmissionTypeSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					items.add(item);
				}
			}
		});
		return items;
	}

	public static List<AdmissionTypeSO> Get_Items() throws DBException, Exception {
		return (new AdmissionTypeService().GetItems());
	}

	@Override
	public List<AdmissionTypeSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<AdmissionTypeSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public AdmissionTypeSO Add(final AdmissionTypeSO item) throws DBException,
			Exception {
		dbHelper.ExecuteInsertWithSequence(
				StudentAdmission.STUDENT_ADMISSION_TYPE.SEQ,
				StudentAdmission.STUDENT_ADMISSION_TYPE.INSERT,
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
	public AdmissionTypeSO Update(final AdmissionTypeSO item)
			throws DBException, Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.STUDENT_ADMISSION_TYPE.UPDATE,
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
				StudentAdmission.STUDENT_ADMISSION_TYPE.DELETE, ids);

	}
}