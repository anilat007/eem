package com.kbit.eem.webapi.Configurations.StudentAdmission;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbit.eem.constants.ApiPaths;
import com.kbit.eem.controllers.JSonRepositoryBaseController;
import com.kbit.eem.models.IServiceUiMapper;
import com.kbit.eem.models.service.Configurations.StudentAdmission.AdmissionCategorySO;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.AdmissionCategory;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.StudentAdmission.AdmissionCategoryService;
import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Student.admissionCategory)
public class AdmissionCategoryApi extends JSonRepositoryBaseController<AdmissionCategory, AdmissionCategorySO> {
	static Logger logger = Logger.getLogger(AdmissionCategoryApi.class);	
	Repository<AdmissionCategorySO> repository = new AdmissionCategoryService();
	IServiceUiMapper<AdmissionCategory, AdmissionCategorySO> mapper = new ServiceUIMapper<AdmissionCategory, AdmissionCategorySO>(
			AdmissionCategory.class, AdmissionCategorySO.class);


	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse getItems() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.GetItems())));
		} catch (Exception e) {
			if(!(e instanceof DBException)){
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse addItem(@RequestBody AdmissionCategory itemToAdd) {
		try {
			AdmissionCategorySO item = mapper.MapToServiceModel(itemToAdd);
			item.setUserId(this.getUserName());
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.Add(item))));
		} catch (Exception e) {
			if(!(e instanceof DBException)){
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(value = ApiPaths.remove, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse removeItem(@RequestBody int[] ids) {
		try {
			repository.Remove(ids);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if(!(e instanceof DBException)){
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody
	JSonResponse udpateItem(@RequestBody AdmissionCategory itemToUpdate) {
		try {
			AdmissionCategorySO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if(!(e instanceof DBException)){
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
}