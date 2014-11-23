package com.kbit.eem.DBModel.util;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class ConfigurationEntity extends BaseAuditEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 20, unique=true)
	@NotNull
	private String name;

	@Column(name = "ACTIVE")
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
