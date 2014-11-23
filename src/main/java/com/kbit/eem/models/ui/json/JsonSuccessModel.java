package com.kbit.eem.models.ui.json;

public class JsonSuccessModel {
	String message;
	String redirectTo;
	Object data;
	
	public static JsonSuccessModel Empty;
	
	static{
		Empty = new JsonSuccessModel();
	}

	public JsonSuccessModel(String message, String redirectTo, Object data) {
		this.message = message;
		this.redirectTo = redirectTo;
		this.data = data;
	}

	public JsonSuccessModel() {
		this(null, null, null);
	}

	public JsonSuccessModel(String message) {
		this(message, null, null);
	}
	
	public JsonSuccessModel(Object data) {
		this(null, null, data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRedirectTo() {
		return redirectTo;
	}

	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}
}
