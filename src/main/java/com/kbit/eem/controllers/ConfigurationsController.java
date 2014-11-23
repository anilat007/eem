package com.kbit.eem.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.constants.ViewNames;

@Controller
public class ConfigurationsController {
	Logger logger = Logger.getLogger(ConfigurationsController.class);

	@RequestMapping(value = ActionPaths.Configurations.receiptConfiguration, method = RequestMethod.GET)
	public ModelAndView ReceiptConfiguration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewNames.Configurations.receiptConfiguration);
		return mv;
	}
}
