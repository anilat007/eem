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
import com.kbit.eem.models.service.Configurations.StudentAdmission.CourseSO;
import com.kbit.eem.models.ui.Configurations.StudentAdmission.Course;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.StudentAdmission.CourseService;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Student.course)
public class CourseApi extends JSonRepositoryBaseController<Course, CourseSO> {
	static Logger logger = Logger.getLogger(CourseApi.class);	
	Repository<CourseSO> repository = new CourseService();
	IServiceUiMapper<Course, CourseSO> mapper = new ServiceUIMapper<Course, CourseSO>(
			Course.class, CourseSO.class);

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
	JSonResponse addItem(@RequestBody Course itemToAdd) {
		try {
			CourseSO item = mapper.MapToServiceModel(itemToAdd);
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
	JSonResponse udpateItem(@RequestBody Course itemToUpdate) {
		try {
			CourseSO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			Helper.logError(logger, e);
			return null;
		}
	}
}
