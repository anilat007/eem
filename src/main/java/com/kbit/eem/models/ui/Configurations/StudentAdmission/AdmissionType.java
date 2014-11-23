package com.kbit.eem.models.ui.Configurations.StudentAdmission;

import com.kbit.eem.models.ui.BaseModel;

public class AdmissionType extends BaseModel {
	private int id;
	private String name;

	public AdmissionType() {
		this.id = -1;
		this.name = "";
	}

	public AdmissionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s}", id, name);
	}
}
