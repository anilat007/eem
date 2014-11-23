package com.kbit.eem.models.ui;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class BaseModel implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		//
	}

	public void validate(Errors errors){
		if(this.supports(this.getClass())){
			this.validate(this, errors);
		}
	}
}
