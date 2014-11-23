package com.kbit.eem.constants.query.Configurations;

import com.kbit.eem.constants.SqlQuery;

public class Receipt {
	public static class FEE_RECEIPT_TYPE_MASTER {
		private static final String TABLE = "FEE_RECEIPT_TYPE_MASTER";
		public static final String SEQ = SqlQuery
				.getNextSeq("FEE_RECEIPT_TYPE_NO_SEQ");

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE);
		public static final String SEARCH_BY_RECEIPT_TYPE_NAME = SqlQuery
				.getSelect(TABLE, "FEE_RECEIPT_TYPE_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"FEE_RECEIPT_TYPE_NO IN (%s)");

		public static final String INSERT = String.format(
				SqlQuery.getInsert(TABLE, new String[] { "USER_TIMESTAMP",
						"FEE_RECEIPT_TYPE_NO", "FEE_RECEIPT_TYPE_NAME",
						"USER_ID" }, new String[] { "%s", "?", "?", "?" }),
				SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "FEE_RECEIPT_TYPE_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"FEE_RECEIPT_TYPE_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class HEAD_ACCOUNT_MASTER {
		private static final String TABLE = "HEAD_ACCOUNT_MASTER";
		public static final String SEQ = SqlQuery.getNextSeq("HEAD_ACCOUNT_NO_SEQ");

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE);
		public static final String SEARCH_BY_HEAD_ACCOUNT_NAME = SqlQuery
				.getSelect(TABLE, "HEAD_ACCOUNT_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"HEAD_ACCOUNT_NO IN (%s)");

		public static final String INSERT = String
				.format(SqlQuery.getInsert(TABLE, new String[] {
						"USER_TIMESTAMP", "HEAD_ACCOUNT_NO", "ACCOUNT_NO",
						"HEAD_ACCOUNT_NAME", "USER_ID" }, new String[] { "%s",
						"?", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "ACCOUNT_NO=?, HEAD_ACCOUNT_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"HEAD_ACCOUNT_NO=?"), SqlQuery.SYSDATE_LONG);
	}
}
