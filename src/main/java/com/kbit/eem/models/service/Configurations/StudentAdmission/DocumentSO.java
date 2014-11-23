package com.kbit.eem.models.service.Configurations.StudentAdmission;

public class DocumentSO {
	private int id;
	private String name;
	private String remarks;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
	
	@Override
	public String toString() {
		return String.format("{ID:%d, Name:%s, Remarks:%s, UserID:%s}",  id, name, remarks, userId);
	}
}
