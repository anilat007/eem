package com.kbit.eem.models.ui.Configurations.StudentAdmission;

import com.kbit.eem.models.ui.BaseModel;

public class Documents extends BaseModel {
	int id;
	String name;
	String remarks;

	public Documents() {
		this.id = -1;
		this.name = "";
	}

	public Documents(int id, String name) {
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Remarks:%s}", id, name, remarks);
	}
}
