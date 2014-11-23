package com.kbit.eem.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.logging.Logger;

import com.kbit.eem.controllers.JSonRepositoryBaseController;
import com.kbit.eem.models.IServiceUiMapper;

public class ServiceUIMapper<TModelUI, TModelService> implements IServiceUiMapper<TModelUI, TModelService> {
	static Logger logger = Logger.getLogger(JSonRepositoryBaseController.class);
	Class<TModelUI> uiClass;
	Class<TModelService> serviceClass;
	
	public ServiceUIMapper(Class<TModelUI> uiClass, Class<TModelService> serviceClass){
		this.uiClass = uiClass;
		this.serviceClass = serviceClass;
	}
	
	public TModelUI MapToUIModel(TModelService source) {
		TModelUI destination = null;
		try {
 			destination = uiClass.newInstance();
			BeanUtils.copyProperties(destination, source);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return destination;
	}
	
	public TModelService MapToServiceModel(TModelUI source) {
		TModelService destination = null;
		try {
			destination = serviceClass.newInstance();
			BeanUtils.copyProperties(destination, source);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return destination;
	}
	
	public List<TModelUI> MapToUIModel(List<TModelService> source) {
		List<TModelUI> destination = new ArrayList<TModelUI>();
		try {
			for (TModelService s : source) {
				TModelUI d = uiClass.newInstance();
				BeanUtils.copyProperties(d, s);
				destination.add(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	
	public List<TModelService> MapToServiceModel(List<TModelUI> source) {
		List<TModelService> destination = new ArrayList<TModelService>();
		try {
			for (TModelUI s : source) {
				TModelService d = serviceClass.newInstance();
				BeanUtils.copyProperties(d, s);
				destination.add(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}