package com.kbit.eem.models.ui.RoleModule;

import com.kbit.eem.models.ui.BaseModel;

public class GroupModel extends BaseModel {
	private int id = -1;
	private String name;
	private int parentModuleId;
	private String viewName;

	public GroupModel(int groupId, String groupName, int parentModuleId) {
		this.id = groupId;
		this.name = groupName;
		this.parentModuleId = parentModuleId;

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

	public int getParentModuleId() {
		return parentModuleId;
	}

	public void setParentModuleId(int parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
