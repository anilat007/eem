package com.kbit.eem.webapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.models.ui.UserManagement.ChangePasswordModel;
import com.kbit.eem.models.ui.json.JSonResponse;
import com.kbit.eem.models.ui.json.JsonSuccessModel;

@Controller
@RequestMapping("/api/usermgmt")
public class ChangePasswordApi {
	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public @ResponseBody
	JSonResponse doLogin(@RequestBody ChangePasswordModel changePasswordModel,
			BindingResult bindingResult) {
		try {
			JSonResponse response;
			changePasswordModel.validate(bindingResult);

			if (bindingResult.hasErrors()) {
				response = new JSonResponse(null, bindingResult.getAllErrors(),
						HttpStatus.BAD_REQUEST);
			} else {
				String redirectTo = ActionPaths.UserManagement.LOGIN;
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
