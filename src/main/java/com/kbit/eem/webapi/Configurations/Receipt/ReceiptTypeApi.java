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
import com.kbit.eem.models.service.Configurations.Receipt.ReceiptTypeSO;
import com.kbit.eem.models.ui.Configurations.Receipt.ReceiptType;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.service.Configurations.Receipt.ReceiptTypeService;
import com.kbit.eem.utils.DBException;
import com.kbit.eem.utils.Helper;
import com.kbit.eem.utils.ServiceUIMapper;

@Controller
@RequestMapping(ApiPaths.Config.Receipt.receiptType)
public class ReceiptTypeApi extends JSonRepositoryBaseController<ReceiptType, ReceiptTypeSO> {
	static Logger logger = Logger.getLogger(ReceiptTypeApi.class);	
	Repository<ReceiptTypeSO> repository = new ReceiptTypeService();
	IServiceUiMapper<ReceiptType, ReceiptTypeSO> mapper = new ServiceUIMapper<ReceiptType, ReceiptTypeSO>(
			ReceiptType.class, ReceiptTypeSO.class);

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
	JSonResponse addItem(@RequestBody ReceiptType itemToAdd) {
		try {
			ReceiptTypeSO item = mapper.MapToServiceModel(itemToAdd);
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
	JSonResponse udpateItem(@RequestBody ReceiptType itemToUpdate) {
		try {
			ReceiptTypeSO item = mapper.MapToServiceModel(itemToUpdate);
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