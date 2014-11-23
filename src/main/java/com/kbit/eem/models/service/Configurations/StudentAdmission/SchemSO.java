package com.kbit.eem.models.service.Configurations.StudentAdmission;

public class SchemSO {
	int id;
	String name;
	String userId;
	String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Status:%s UserID:%s}",  id, name, status, userId);
	}
}
