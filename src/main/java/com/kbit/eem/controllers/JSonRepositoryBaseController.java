package com.kbit.eem.controllers;

import org.jboss.logging.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kbit.eem.utils.Helper;

public abstract class JSonRepositoryBaseController<TModelUI, TModelService> extends
		BaseController {
	Logger logger = Logger.getLogger(JSonRepositoryBaseController.class);
	
	public String getUserName(){
		try{
			return SecurityContextHolder.getContext().getAuthentication().getName();	
		}
		catch(Exception ex){
			logger.error(Helper.getMethodName() + ex.getMessage());
			return null;
		}
	}
}
