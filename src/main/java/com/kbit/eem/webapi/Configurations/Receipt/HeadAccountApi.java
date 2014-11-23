package com.kbit.eem.webapi.Configurations.Receipt;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbit.eem.constants.ApiPaths;
import com.kbit.eem.controllers.JSonRepositoryBaseController;
import com.kbit.eem.models.IServiceUiMapper;
import com.kbit.eem.models.service.Configurations.Receipt.HeadAccountSO;
import com.kbit.eem.models.ui.Configurations.Receipt.HeadAccount;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.Receipt.HeadAccountService;
import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Receipt.headAccount)
public class HeadAccountApi extends
		JSonRepositoryBaseController<HeadAccount, HeadAccountSO> {
	static Logger logger = Logger.getLogger(HeadAccountApi.class);
	Repository<HeadAccountSO> repository = new HeadAccountService();
	IServiceUiMapper<HeadAccount, HeadAccountSO> mapper = new ServiceUIMapper<HeadAccount, HeadAccountSO>(
			HeadAccount.class, HeadAccountSO.class);

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	JSonResponse getItems() {
		try {
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.GetItems())));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse addItem(@RequestBody HeadAccount itemToAdd) {
		try {
			HeadAccountSO item = mapper.MapToServiceModel(itemToAdd);
			item.setUserId(this.getUserName());
			return new JSonResponse(new JsonSuccessModel(
					mapper.MapToUIModel(repository.Add(item))));
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
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
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody
	JSonResponse udpateItem(@RequestBody HeadAccount itemToUpdate) {
		try {
			HeadAccountSO item = mapper.MapToServiceModel(itemToUpdate);
			item.setUserId(this.getUserName());
			repository.Update(item);
			return new JSonResponse(JsonSuccessModel.Empty);
		} catch (Exception e) {
			if (!(e instanceof DBException)) {
				Helper.logError(logger, e);
			}
			return new JSonResponse(e);
		}
	}
}