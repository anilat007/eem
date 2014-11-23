package com.kbit.eem.models.ui.Configurations.StudentAdmission;

import com.kbit.eem.models.ui.BaseModel;

public class Scheme extends BaseModel {
	int id;
	String name;
	String status;

	public Scheme() {
		this.id = -1;
		this.name = "";
	}

	public Scheme(int id, String name) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Status:%s}", id, name, status);
	}

}
