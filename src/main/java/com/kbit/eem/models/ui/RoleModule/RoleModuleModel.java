package com.kbit.eem.models.ui.RoleModule;

import java.util.Iterator;
import java.util.List;

import com.kbit.eem.models.ui.BaseModel;
import com.kbit.eem.models.ui.RoleModule.GroupModel;

public class RoleModuleModel extends BaseModel {
	private int id = -1;
	private String name;
	private String imageName;
	private List<GroupModel> groups;

	public RoleModuleModel(int moduleId, String name, String moduleImageName,
			List<GroupModel> groups) {
		this.id = moduleId;
		this.name = name;
		this.groups = groups;
		this.imageName = moduleImageName;
	}

	public void addGroup(GroupModel group) {
		this.groups.add(group);
	}

	public GroupModel getGroup(int groupId) {
		Iterator<GroupModel> groupsIterator = groups.iterator();
		GroupModel group = null;
		while (groupsIterator.hasNext()) {
			group = groupsIterator.next();
			if (groupId == group.getId()) {
				break;
			}
			group = null;
		}
		return group;
	}

	public boolean contains(int groupId) {
		return (this.getGroup(groupId) != null);
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

	public List<GroupModel> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupModel> groups) {
		this.groups = groups;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
