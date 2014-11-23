package com.kbit.eem.models.service.Configurations.StudentAdmission;

public class BoardExamSO {
	private int id;
	private String name;
	private String userId;
	private int totalMarks;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, UserID:%s, TotalMarks:%d}",  id, name, userId, totalMarks);
	}
}
