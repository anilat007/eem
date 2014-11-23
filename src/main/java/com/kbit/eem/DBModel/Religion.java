package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the RELIGIONS database table.
 */
@Entity
@Table(name = "RELIGIONS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "RELIGIONS_SEQ")
public class Religion extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public Religion() {
	}
}