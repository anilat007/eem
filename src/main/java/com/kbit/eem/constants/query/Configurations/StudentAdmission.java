package com.kbit.eem.constants.query.Configurations;

import com.kbit.eem.constants.SqlQuery;

public class StudentAdmission {
	public static class CATEGORY_DETAILS {
		private static final String TABLE = "CATEGORY_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("CATEGORY_NO_SEQ");

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE);
		public static final String SEARCH_BY_CATEGORYNAME = SqlQuery.getSelect(
				TABLE, "CATEGORY_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"CATEGORY_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "CATEGORY_NO",
						"CATEGORY_NAME", "USER_ID" }, new String[] { "%s", "?",
						"?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "CATEGORY_NAME=?, USER_ID=?,USER_TIMESTAMP=%s",
				"CATEGORY_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class STUDENT_ADMISSION_TYPE {
		private static final String TABLE = "STUDENT_ADMISSION_TYPE";
		public static final String SEQ = SqlQuery
				.getNextSeq("STUDENT_ADMISSION_TYPE_NO_SEQ");

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE);
		public static final String SEARCH_BY_ADMISSION_TYPE_NAME = SqlQuery
				.getSelect(TABLE, "STUDENT_ADMISSION_TYPE_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"STUDENT_ADMISSION_TYPE_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP",
						"STUDENT_ADMISSION_TYPE_NO",
						"STUDENT_ADMISSION_TYPE_NAME", "USER_ID" },
				new String[] { "%s", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE,
				"STUDENT_ADMISSION_TYPE_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"STUDENT_ADMISSION_TYPE_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class BLOOD_GROUP_DETAILS {
		private static final String TABLE = "BLOOD_GROUP_DETAILS";
		public static final String SEQ = SqlQuery
				.getNextSeq("BLOOD_GROUP_NO_SEQ");

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				"BLOOD_GROUP_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"BLOOD_GROUP_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "BLOOD_GROUP_NO",
						"BLOOD_GROUP_NAME", "USER_ID" }, new String[] { "%s",
						"?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "BLOOD_GROUP_NAME=?, USER_ID=?, USER_TIMESTAMP=?",
				"BLOOD_GROUP_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class QUALIFIED_EXAM_BOARD_DETAILS {
		private static final String TABLE = "QUALIFIED_EXAM_BOARD_DETAILS";
		public static final String SEQ = SqlQuery
				.getNextSeq("QUALIFIED_EXAM_BOARD_NO_SEQ");
		private static final String[] COLUMNS = new String[] {
				"QUALIFIED_EXAM_BOARD_NO", "QUALIFIED_EXAM_BOARD_NAME",
				"TOTAL_MARKS" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "QUALIFIED_EXAM_BOARD_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"QUALIFIED_EXAM_BOARD_NO IN (%s)");

		public static final String INSERT = String.format(
				SqlQuery.getInsert(TABLE, new String[] { "USER_TIMESTAMP",
						"QUALIFIED_EXAM_BOARD_NO", "QUALIFIED_EXAM_BOARD_NAME",
						"TOTAL_MARKS", "USER_ID" }, new String[] { "%s", "?",
						"?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String
				.format(SqlQuery
						.getUpdate(
								TABLE,
								"QUALIFIED_EXAM_BOARD_NAME=?, TOTAL_MARKS=?, USER_ID=?, USER_TIMESTAMP=%s",
								"QUALIFIED_EXAM_BOARD_NO=?"),
						SqlQuery.SYSDATE_LONG);
	}

	public static class CASTE_DETAILS {
		private static final String TABLE = "CASTE_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("CASTE_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "CASTE_NO",
				"CASTE_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "CASTE_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"CASTE_NO IN (%s)");

		public static final String INSERT = String.format(
				SqlQuery.getInsert(TABLE, new String[] { "USER_TIMESTAMP",
						"CASTE_NO", "CASTE_NAME", "USER_ID" }, new String[] {
						"%s", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "CASTE_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"CASTE_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class COURSE_DETAILS {
		private static final String TABLE = "COURSE_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("COURSE_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "COURSE_NO",
				"COURSE_NAME", "NO_OF_YEARS" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "COURSE_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"COURSE_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "COURSE_NO",
						"COURSE_NAME", "NO_OF_YEARS", "USER_ID" },
				new String[] { "%s", "?", "?", "?", "?" }),
				SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, // COURSE_NAME=?,
				"NO_OF_YEARS=?, USER_ID=?, USER_TIMESTAMP=%s", "COURSE_NO=?"),
				SqlQuery.SYSDATE_LONG);
	}

	public static class DOCUMENTS_MASTER {
		private static final String TABLE = "DOCUMENTS_MASTER";
		public static final String SEQ = SqlQuery.getNextSeq("DOCUMENT_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "DOCUMENT_NO",
				"DOCUMENT_NAME", "DOCUMENT_REMARKS" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);

		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "DOCUMENT_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"DOCUMENT_NO IN (%s)");

		public static final String INSERT = String
				.format(SqlQuery.getInsert(TABLE, new String[] {
						"USER_TIMESTAMP", "DOCUMENT_NO", "DOCUMENT_NAME",
						"DOCUMENT_REMARKS", "USER_ID" }, new String[] { "%s",
						"?", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String
				.format(SqlQuery
						.getUpdate(
								TABLE,
								"DOCUMENT_NAME=?, DOCUMENT_REMARKS=?, USER_ID=?, USER_TIMESTAMP=%s",
								"DOCUMENT_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class COUNTRY_DETAILS {
		private static final String TABLE = "COUNTRY_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("COUNTRY_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "COUNTRY_NO",
				"COUNTRY_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "COUNTRY_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"COUNTRY_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "COUNTRY_NO",
						"COUNTRY_NAME", "USER_ID" }, new String[] { "%s", "?",
						"?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "COUNTRY_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"COUNTRY_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class OCCUPATION_DETAILS {
		private static final String TABLE = "OCCUPATION_DETAILS";
		public static final String SEQ = SqlQuery
				.getNextSeq("OCCUPATION_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "OCCUPATION_NO",
				"OCCUPATION_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "OCCUPATION_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"OCCUPATION_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "OCCUPATION_NO",
						"OCCUPATION_NAME", "USER_ID" }, new String[] { "%s",
						"?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "OCCUPATION_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"OCCUPATION_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class PREVIOUS_INSTITUTION_DETAILS {
		private static final String TABLE = "PREVIOUS_INSTITUTION_DETAILS";
		public static final String SEQ = SqlQuery
				.getNextSeq("PREVIOUS_INSTITUTION_NO_SEQ");
		private static final String[] COLUMNS = new String[] {
				"PREVIOUS_INSTITUTION_NO", "PREVIOUS_INSTITUTION_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "PREVIOUS_INSTITUTION_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"PREVIOUS_INSTITUTION_NO IN (%s)");

		public static final String INSERT = String.format(
				SqlQuery.getInsert(TABLE, new String[] { "USER_TIMESTAMP",
						"PREVIOUS_INSTITUTION_NO", "PREVIOUS_INSTITUTION_NAME",
						"USER_ID" }, new String[] { "%s", "?", "?", "?" }),
				SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE,
				"PREVIOUS_INSTITUTION_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"PREVIOUS_INSTITUTION_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class STUDENT_QUALIFIED_EXAM_DETAILS {
		private static final String TABLE = "STUDENT_QUALIFIED_EXAM_DETAILS";
		public static final String SEQ = SqlQuery
				.getNextSeq("STUDENT_QUALIFIED_EXAM_NO_SEQ");
		private static final String[] COLUMNS = new String[] {
				"STUDENT_QUALIFIED_EXAM_NO", "STUDENT_QUALIFIED_EXAM_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "STUDENT_QUALIFIED_EXAM_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"STUDENT_QUALIFIED_EXAM_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP",
						"STUDENT_QUALIFIED_EXAM_NO",
						"STUDENT_QUALIFIED_EXAM_NAME", "USER_ID" },
				new String[] { "%s", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE,
				"STUDENT_QUALIFIED_EXAM_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"STUDENT_QUALIFIED_EXAM_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class RELIGION_DETAILS {
		private static final String TABLE = "RELIGION_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("RELIGION_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "RELIGION_NO",
				"RELIGION_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "RELIGION_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"RELIGION_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "RELIGION_NO",
						"RELIGION_NAME", "USER_ID" }, new String[] { "%s", "?",
						"?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "RELIGION_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"RELIGION_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class SCHEME_MASTER {
		public static final String SCHEME_NEXT = "NEXT"; 
		private static final String TABLE = "SCHEME_MASTER";
		public static final String SEQ = SqlQuery.getNextSeq("SCHEME_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "SCHEME_NO",
				"SCHEME_NAME", "STATUS" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "SCHEME_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"SCHEME_NO IN (%s)");

		public static final String INSERT = String.format(SqlQuery.getInsert(
				TABLE, new String[] { "USER_TIMESTAMP", "SCHEME_NO",
						"SCHEME_NAME", "STATUS", "USER_ID" }, new String[] {
						"%s", "?", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "SCHEME_NAME=?, USER_ID=?, USER_TIMESTAMP=%s", // STATUS=?
				"SCHEME_NO=?"), SqlQuery.SYSDATE_LONG);
	}

	public static class STATE_DETAILS {
		private static final String TABLE = "STATE_DETAILS";
		public static final String SEQ = SqlQuery.getNextSeq("STATE_NO_SEQ");
		private static final String[] COLUMNS = new String[] { "STATE_NO",
				"STATE_NAME" };

		public static final String SEARCH_ALL = SqlQuery.getSelect(TABLE,
				COLUMNS);
		public static final String SEARCH_BY_NAME = SqlQuery.getSelect(TABLE,
				COLUMNS, "STATE_NAME LIKE '%?%'");
		public static final String DELETE = SqlQuery.getDelete(TABLE,
				"STATE_NO IN (%s)");

		public static final String INSERT = String.format(
				SqlQuery.getInsert(TABLE, new String[] { "USER_TIMESTAMP",
						"STATE_NO", "STATE_NAME", "USER_ID" }, new String[] {
						"%s", "?", "?", "?" }), SqlQuery.SYSDATE_LONG);

		public static final String UPDATE = String.format(SqlQuery.getUpdate(
				TABLE, "STATE_NAME=?, USER_ID=?, USER_TIMESTAMP=%s",
				"STATE_NO=?"), SqlQuery.SYSDATE_LONG);
	}
}