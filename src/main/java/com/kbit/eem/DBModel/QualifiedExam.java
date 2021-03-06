package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the QUALIFIED_EXAMS database table.
 */
@Entity
@Table(name = "QUALIFIED_EXAMS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "QUALIFIED_EXAMS")
public class QualifiedExam extends ConfigurationEntity{
	private static final long serialVersionUID = 1L;

	public QualifiedExam() {
	}
}