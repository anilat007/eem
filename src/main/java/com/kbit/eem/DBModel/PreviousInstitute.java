package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the PREVIOUS_INSTITUTES database table.
 */
@Entity
@Table(name = "PREVIOUS_INSTITUTES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "PREVIOUS_INSTITUTES_SEQ")
public class PreviousInstitute extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public PreviousInstitute() {
	}
}