package com.kbit.eem.models.service.Configurations.StudentAdmission;

public class CourseSO {
	private int id;
	private String name;
	private int years;
	private String userId;
	
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
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Years:%d, UserID:%s}",  id, name, years, userId);
	}
}
