package com.kbit.eem.models.ui.UserManagement;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.kbit.eem.models.ui.BaseModel;

public class LoginModel extends BaseModel {
	String userId;
	String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return LoginModel.class.isAssignableFrom(aClass);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId-required", "User Id is required.");
		ValidationUtils.rejectIfEmpty(errors, "password", "password-required", "Password is required.");
	}	
}
