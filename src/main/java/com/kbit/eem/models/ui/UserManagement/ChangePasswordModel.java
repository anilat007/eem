package com.kbit.eem.models.ui.UserManagement;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.kbit.eem.models.ui.BaseModel;

public class ChangePasswordModel extends BaseModel {
	String userId;
	String password;
	String newPassword;
	String confirmPassword;

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return ChangePasswordModel.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ChangePasswordModel model = (ChangePasswordModel) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId",
				"userId-required", "User Id is required.");
		ValidationUtils.rejectIfEmpty(errors, "password", "password-required",
				"Password is required.");
		ValidationUtils.rejectIfEmpty(errors, "newPassword",
				"newPassword-required", "New password is required.");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword",
				"confirmPassword-required", "Confirm password is required.");

		if (!model.getNewPassword().equals("")
				&& !model.getConfirmPassword().equals("") && !model.getNewPassword().equals(model.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmPassword-nomatch", "New and Confirm passwords should be same.");
		}

	}
}
