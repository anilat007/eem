package com.kbit.eem.controllers.UserManagement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.constants.ViewNames;
import com.kbit.eem.controllers.BaseController;
import com.kbit.eem.models.ui.UserManagement.ChangePasswordModel;
import com.kbit.eem.service.usermanagement.UserService;

@Controller
public class ChangePasswordController extends BaseController {
	Logger logger = Logger.getLogger(ChangePasswordController.class);
			
	@Autowired
	UserService userService;
	
	@RequestMapping(value = ActionPaths.UserManagement.CHANGE_PASSWORD, method = RequestMethod.GET)
	public String ChangePassword(ModelMap modelMap) {
		ChangePasswordModel model = new ChangePasswordModel();
		modelMap.addAttribute("model", model);
		return ViewNames.UserManagement.CHANGE_PASSWORD;
	}

	@RequestMapping(value = ActionPaths.UserManagement.CHANGE_PASSWORD, method = RequestMethod.POST)
	public String ChangePassword(
			@ModelAttribute("model") ChangePasswordModel model,
			BindingResult bindingResult, ModelMap modelMap) {
		String result = ViewNames.UserManagement.CHANGE_PASSWORD;
		// Validate
		model.validate(bindingResult);

		if (!bindingResult.hasErrors()) {
			String userId = model.getUserId();
			String password = model.getPassword();
			String newPassword = model.getNewPassword();
			
			if (userService.changePassword(userId, password, newPassword)) {
				modelMap.addAttribute("m", "1");
				result = getRedirectView(ActionPaths.UserManagement.LOGIN);
			}
		}
		return result;
	}
}
