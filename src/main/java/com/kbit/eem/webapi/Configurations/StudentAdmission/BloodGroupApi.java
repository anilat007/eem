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
import com.kbit.eem.models.service.Configurations.StudentAdmission.BloodGroupSO;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.BloodGroup;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.StudentAdmission.BloodGroupService;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Student.bloodGroup)
public class BloodGroupApi extends JSonRepositoryBaseController<BloodGroup, BloodGroupSO> {
	static Logger logger = Logger.getLogger(BloodGroupApi.class);
	Repository<BloodGroupSO> repository = new BloodGroupService();

	IServiceUiMapper<BloodGroup, BloodGroupSO> mapper = new ServiceUIMapper<BloodGroup, BloodGroupSO>(
			BloodGroup.class, BloodGroupSO.class);

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
	JSonResponse addItem(@RequestBody BloodGroup itemToAdd) {
		try {
			BloodGroupSO item = mapper.MapToServiceModel(itemToAdd);
			item.setUserId(this.getUserName());
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.Add(item))));
		} catch (Exception ex) {
			Helper.logError(logger, ex);
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
	JSonResponse udpateItem(@RequestBody BloodGroup itemToUpdate) {
		try {
			BloodGroupSO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception ex) {
			Helper.logError(logger, ex);
			return null;
		}
	}
}