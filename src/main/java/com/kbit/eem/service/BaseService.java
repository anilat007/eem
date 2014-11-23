package com.kbit.eem.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kbit.eem.DBModel.util.BaseAuditEntity;
import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;

public class BaseService {
	static Logger logger = Logger.getLogger(BaseService.class);
	
	protected boolean HandleException(Exception e){
		boolean rethrow = true;
		if (!(e instanceof DBException)) {
			Helper.logError(logger, e, 4);
		}
		return rethrow;
	}
	
	private String getUserName(){
		try{
			return SecurityContextHolder.getContext().getAuthentication().getName();	
		}
		catch(Exception ex){
			logger.error(Helper.getMethodName() + ex.getMessage());
			return null;
		}
	}
	
	protected void setAuditDetails(BaseAuditEntity auditEntity, String updatedBy, Date updatedOn){
		auditEntity.setUpdatedBy(updatedBy);
		auditEntity.setUpdatedOn(updatedOn);
	}

	protected void setAuditDetails(BaseAuditEntity auditEntity){
		this.setAuditDetails(auditEntity, this.getUserName(), new Date());
	}
}
