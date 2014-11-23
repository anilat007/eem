
package com.kbit.eem.controllers.UserManagement;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
/*import org.springframework.ui.ModelMap;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.constants.ViewNames;
import com.kbit.eem.controllers.BaseController;
import com.kbit.eem.models.ui.UserManagement.LoginModel;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends BaseController {
	Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = ActionPaths.UserManagement.LOGIN, method = RequestMethod.GET)
	public String Login(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
			throws Exception {
		try {
			LoginModel model = new LoginModel();
			modelMap.addAttribute("model", model);
			if (error != null) {
				modelMap.addAttribute("errormsg",
						"Please provide appropriate credentials.");
			}
			if (logout != null) {
				logger.info(request.getSession().getId());

				modelMap.addAttribute("message",
						"You have been logged out successfully.");
			}
			logger.info("Landed on login page.");

			return ViewNames.UserManagement.LOGIN;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	/*
	 * @RequestMapping(value = ActionPaths.UserManagement.LOGIN, method =
	 * RequestMethod.POST) public String Login(@ModelAttribute("model")
	 * LoginModel model, BindingResult bindingResult, ModelMap modelMap) throws
	 * Exception { try { String result = ViewNames.UserManagement.LOGIN; //
	 * Validate model.validate(bindingResult);
	 * 
	 * if (!bindingResult.hasErrors()) { String userId = model.getUserId();
	 * String password = model.getPassword(); UserManagementService service =
	 * new UserManagementService(); if (service.validateUser(userId, password))
	 * { setSessionValue(SessionVar.LOGIN_USER_ID, userId);
	 * logger.info("Redirecting to role modules page."); result =
	 * getRedirectView(ActionPaths.RoleModule.ROLE_MODULE); } } else {
	 * logger.info("Invalid login credentials."); } return result; } catch
	 * (Exception ex) { logger.error(ex.getMessage()); throw ex; } }
	 */
}