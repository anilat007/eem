package com.kbit.eem.utils;

public class ListMenuItem {
	String path;
	String i18id;
	String fullPath;

	public ListMenuItem(String name, String path, String fullPath) {
		super();
		this.path = path;
		this.i18id = name;
		this.fullPath = fullPath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getI18id() {
		return i18id;
	}

	public void setI18id(String i18id) {
		this.i18id = i18id;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
}
