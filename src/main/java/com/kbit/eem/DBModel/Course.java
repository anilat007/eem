package com.kbit.eem.DBModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the COURSES database table.
 */
@Entity
@Table(name = "COURSES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "COURSES_SEQ")
public class Course extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "YEARS")
	@NotNull
	private int years;

	public Course() {
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
}