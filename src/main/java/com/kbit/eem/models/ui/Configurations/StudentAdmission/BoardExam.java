package com.kbit.eem.models.ui.Configurations.StudentAdmission;

import com.kbit.eem.models.ui.BaseModel;

public class BoardExam extends BaseModel {
	private int id;
	private String name;
	private int totalMarks;
	
	public BoardExam() {
		this.id = -1;
		this.name = "";
		this.totalMarks = 0;
	}

	public BoardExam(int id, String name, int totalMarks) {
		this.id = id;
		this.name = name;
		this.totalMarks = totalMarks;
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
	
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, TotalMarks:%s}",  id, name, totalMarks);
	}
}
