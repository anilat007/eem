package com.kbit.eem.DBModel;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the CATEGORIES database table.
 */
@Entity
@Table(name = "CATEGORIES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "CATEGORIES_SEQ")
public class Category extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	public Category() {
	}
}