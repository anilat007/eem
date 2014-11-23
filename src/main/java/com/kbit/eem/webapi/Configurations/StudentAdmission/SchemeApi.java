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
import com.kbit.eem.models.service.Configurations.StudentAdmission.SchemSO;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Scheme;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.StudentAdmission.SchemeService;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Student.scheme)
public class SchemeApi extends JSonRepositoryBaseController<Scheme, SchemSO> {
	static Logger logger = Logger.getLogger(SchemeApi.class);	
	Repository<SchemSO> repository = new SchemeService();
	IServiceUiMapper<Scheme, SchemSO> mapper = new ServiceUIMapper<Scheme, SchemSO>(
			Scheme.class, SchemSO.class);

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse getItems() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.GetItems())));
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse addItem(@RequestBody Scheme itemToAdd) {
		try {
			SchemSO item = mapper.MapToServiceModel(itemToAdd);
			item.setUserId(this.getUserName());
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.Add(item))));
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}
	}

	@RequestMapping(value = ApiPaths.remove, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse removeItem(@RequestBody int[] ids) {
		try {
			repository.Remove(ids);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody
	JSonResponse udpateItem(@RequestBody Scheme itemToUpdate) {
		try {
			SchemSO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}
	}
}