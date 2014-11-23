package com.kbit.eem.DBModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the SCHEMES database table.
 */
@Entity
@Table(name = "SCHEMES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "SCHEMES_SEQ")
public class Scheme extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "STATUS")
	@NotNull
	private boolean activeStatus;

	public Scheme() {
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
}