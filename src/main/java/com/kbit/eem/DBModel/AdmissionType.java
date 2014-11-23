package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the ADMISSION_TYPES database table.
 */
@Entity
@Table(name = "ADMISSION_TYPES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "ADMISSION_TYPES_SEQ")
public class AdmissionType extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public AdmissionType() {
	}
}
