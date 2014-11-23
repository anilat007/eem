package com.kbit.eem.DBModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kbit.eem.DBModel.util.ConfigurationEntity;
import com.kbit.eem.DBModel.util.DBConstants;

/**
 * The persistent class for the DOCUMENTS database table.
 */
@Entity
@Table(name = "DOCUMENTS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "DOCUMENTS_SEQ")
public class Document extends ConfigurationEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "REMARKS")
	private String remarks;

	public Document() {
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
