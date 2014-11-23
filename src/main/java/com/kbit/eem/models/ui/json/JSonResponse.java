package com.kbit.eem.models.ui.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import com.kbit.eem.utils.DBException;

public class JSonResponse {
	private List<JsonErrorModel> errors;
	private JsonSuccessModel model;
	private JsonErrorModel exception;
	private HttpStatus status;
	private boolean success;

	public List<JsonErrorModel> getErrors() {
		return errors;
	}

	public void setErrors(List<JsonErrorModel> errors) {
		this.errors = errors;
	}

	public JsonSuccessModel getModel() {
		return model;
	}

	public void setModel(JsonSuccessModel model) {
		this.model = model;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public JsonErrorModel getException() {
		return exception;
	}

	public void setException(JsonErrorModel exception) {
		this.exception = exception;
	}

	public JSonResponse(JsonSuccessModel model) {
		this(model, HttpStatus.OK, null);
	}

	public JSonResponse(Exception model) {
		this(null, HttpStatus.INTERNAL_SERVER_ERROR, null);
		String errorCode = JsonErrorCodes.GeneralError.toString();

		if (model instanceof DBException) {
			errorCode = JsonErrorCodes.DBError.toString();
		}

		this.setException(new JsonErrorModel(errorCode, null, null));
		this.success = false;
	}

	public JSonResponse(JsonSuccessModel model, HttpStatus status,
			List<JsonErrorModel> errors) {
		this.model = model;
		this.status = status;
		this.errors = errors;
		this.success = (this.errors == null || this.errors.size() == 0);
	}

	public JSonResponse(JsonSuccessModel model, List<ObjectError> errors,
			HttpStatus status) {
		this.model = model;
		this.status = status;
		this.errors = MapToJsonErrorModel(errors);
		this.success = (this.errors == null || this.errors.size() == 0);
	}

	public static List<JsonErrorModel> MapToJsonErrorModel(
			List<ObjectError> errorList) {
		if (errorList == null) {
			return null;
		}

		List<JsonErrorModel> customErrorList = new ArrayList<JsonErrorModel>();

		for (ObjectError objError : errorList) {
			String code = objError.getCode();
			String field = "";

			if (code.contains("-")) {
				field = code.split("-")[0];
			}

			JsonErrorModel customError = new JsonErrorModel(code,
					objError.getDefaultMessage(), field);
			customErrorList.add(customError);
		}
		return customErrorList;
	}
}