package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the BLOOD_GROUPS database table.
 */
@Entity
@Table(name = "BLOOD_GROUPS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "BLOOD_GROUPS_SEQ")
public class BloodGroup extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public BloodGroup() {
	}
}