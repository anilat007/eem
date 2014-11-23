package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the OCCUPATIONS database table.
 */
@Entity
@Table(name = "OCCUPATIONS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "OCCUPATIONS_SEQ")
public class Occupation extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public Occupation() {
	}
}
