package com.kbit.eem.DBModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the BOARD_EXAMS database table.
 */
@Entity
@Table(name = "BOARD_EXAMS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "BOARD_EXAMS_SEQ")
public class BoardExam extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "TOTAL_MARKS")
	@NotNull
	private int totalMarks;

	public BoardExam() {
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
}
