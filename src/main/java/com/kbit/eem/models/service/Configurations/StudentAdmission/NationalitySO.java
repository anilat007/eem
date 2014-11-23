package com.kbit.eem.models.service.Configurations.StudentAdmission;

public class NationalitySO {
	private int id;
	private String name;
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

	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, UserID:%s}",  id, name, userId);
	}
}
