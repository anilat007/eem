package com.kbit.eem.models.ui.Configurations.StudentAdmission;

import com.kbit.eem.models.ui.BaseModel;

public class Course extends BaseModel {
	int id;
	String name;
	int years;
	
	public Course(){
		this.id = -1;
		this.name = "";
		this.years = 0;
	}

	public Course(int id, String name, int years) {
		this.id = id;
		this.name = name;
		this.years = years;
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
	
	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}	
	
	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Years:%d}",  id, name, years);
	}

}
