package com.kbit.eem.service.Configurations.StudentAdmission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kbit.eem.constants.query.Configurations.StudentAdmission;
import com.kbit.eem.models.service.Configurations.StudentAdmission.BoardExamSO;
import com.kbit.eem.service.DBHelper;
import com.kbit.eem.service.IPreparedStatementHandler;
import com.kbit.eem.service.IResultSetHandler;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class BoardExamService extends Repository<BoardExamSO> {
	static Logger logger = Logger.getLogger(BoardExamService.class);
	DBHelper dbHelper = new DBHelper(logger);

	private ArrayList<BoardExamSO> GetItems(String name) throws DBException,
			Exception {
		final ArrayList<BoardExamSO> items = new ArrayList<BoardExamSO>();
		String query = (name == null || name.trim().equals("")) ? StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.SEARCH_ALL
				: String.format(
						StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.SEARCH_BY_NAME,
						name);

		dbHelper.ExeucteGet(query, new IResultSetHandler() {
			@Override
			public void process(ResultSet rs) throws SQLException {
				while (rs.next()) {
					BoardExamSO item = new BoardExamSO();
					item.setId(rs.getInt(1));
					item.setName(rs.getString(2));
					item.setTotalMarks(rs.getInt(3));
					items.add(item);
				}
			}
		});
		return items;
	}
	
	public static List<BoardExamSO> Get_Items() throws DBException, Exception {
		return new BoardExamService().GetItems("");
	}

	@Override
	public List<BoardExamSO> GetItemsBy(Object name) throws DBException,
			Exception {
		return GetItems(name.toString());
	}

	@Override
	public List<BoardExamSO> GetItems() throws DBException, Exception {
		return this.GetItems("");
	}

	@Override
	public BoardExamSO Add(final BoardExamSO item) throws DBException,
			Exception {
		dbHelper.ExecuteInsertWithSequence(
				StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.SEQ,
				StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.INSERT,
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
						ps.setInt(3, item.getTotalMarks());
						ps.setString(4, item.getUserId());
					}
				});
		return item;
	}

	@Override
	public BoardExamSO Update(final BoardExamSO item) throws DBException,
			Exception {
		dbHelper.ExecuteUpdate(
				StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.UPDATE,
				new IPreparedStatementHandler() {
					@Override
					public void process(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, item.getName().trim());
						ps.setInt(2, item.getTotalMarks());
						ps.setString(3, item.getUserId());
						ps.setInt(4, item.getId());
					}
				});
		return item;
	}

	@Override
	public int Remove(int[] ids) throws DBException, Exception {
		return dbHelper.ExeucteDeleteIDs(
				StudentAdmission.QUALIFIED_EXAM_BOARD_DETAILS.DELETE, ids);
	}
}