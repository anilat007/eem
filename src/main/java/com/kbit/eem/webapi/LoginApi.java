package com.kbit.eem.webapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.models.ui.UserManagement.LoginModel;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;

@Controller
@RequestMapping("/api/usermgmt")
public class LoginApi {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse doLogin(@RequestBody LoginModel loginModel,
			BindingResult bindingResult) {
		try {
			JSonResponse response;
			loginModel.validate(bindingResult);

			if (bindingResult.hasErrors()) {
				response = new JSonResponse(null, bindingResult.getAllErrors(),
						HttpStatus.BAD_REQUEST);
			} else {
				String redirectTo = ActionPaths.RoleModule.ROLE_MODULE;
				JsonSuccessModel model = new JsonSuccessModel();
				model.setRedirectTo(redirectTo);
				response = new JSonResponse(model);
			}
			return response;

		} catch (Exception ex) {
			return null;
		}
	}
}
