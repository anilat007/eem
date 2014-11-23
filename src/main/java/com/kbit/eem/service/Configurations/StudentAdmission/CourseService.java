package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.CourseSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class CourseService extends Repository<CourseSO> {
	static Logger logger = Logger.getLogger(CourseService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<CourseSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<CourseSO> items = new ArrayList<CourseSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.COURSE_DETAILS.SEARCH_ALL
				: String.format(StudentAdmission.COURSE_DETAILS.SEARCH_BY_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					CourseSO item = new CourseSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					item.setYears(rs.getInt(3));
					items.add(item);
				}
			}
		});
		return items;
	}

	public static List<CourseSO> Get_Items() throws DBException, Exception {
		return (new CourseService().GetItems());
	}

	@Override
	public List<CourseSO> GetItemsBy(Object name) throws DBException, Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<CourseSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public CourseSO Add(final CourseSO item) throws DBException, Exception {
		dbHelper.ExecuteInsertWithSequence(StudentAdmission.COURSE_DETAILS.SEQ,
				StudentAdmission.COURSE_DETAILS.INSERT,
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
						ps.setInt(3, item.getYears());
						ps.setString(4, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public CourseSO Update(final CourseSO item) throws DBException, Exception {
		dbHelper.ExecuteUpdate(StudentAdmission.COURSE_DETAILS.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						//ps.setString(1, item.getName().trim());
						ps.setInt(1, item.getYears());
						ps.setString(2, item.getUserId());
						ps.setInt(3, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {
		return dbHelper.ExeucteDeleteIDs(
				StudentAdmission.COURSE_DETAILS.DELETE, ids);
	}
}