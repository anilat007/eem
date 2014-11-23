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
import com.kbit.eem.models.service.Configurations.StudentAdmission.YearSO;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Year;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.StudentAdmission.YearService;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Student.year)
public class YearApi extends JSonRepositoryBaseController<Year, YearSO> {
	static Logger logger = Logger.getLogger(YearApi.class);	
	Repository<YearSO> repository = new YearService();
	IServiceUiMapper<Year, YearSO> mapper = new ServiceUIMapper<Year, YearSO>(
			Year.class, YearSO.class);

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse getItems() {
		/*try {
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.GetItems())));
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}*/
		return new JSonResponse(JsonSuccessModel.Empty);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse addItem(@RequestBody Year itemToAdd) {
		/*try {
			YearSO item = mapper.MapToServiceModel(itemToAdd);
			item.setUserId(this.getUserName());
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.Add(item))));
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}*/
		return new JSonResponse(JsonSuccessModel.Empty);
	}

	@RequestMapping(value = ApiPaths.remove, method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse removeItem(@RequestBody int[] ids) {
		/*try {
			repository.Remove(ids);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}*/
		return new JSonResponse(JsonSuccessModel.Empty);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody
	JSonResponse udpateItem(@RequestBody Year itemToUpdate) {
		/*try {
			YearSO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}*/
		return new JSonResponse(JsonSuccessModel.Empty);
	}
}