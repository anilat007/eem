package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the YEARS database table.
 */
@Entity
@Table(name = "YEARS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "YEARS_SEQ")
public class Year extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public Year() {
	}
}