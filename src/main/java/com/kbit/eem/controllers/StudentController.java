package com.kbit.eem.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.constants.ViewNames;

@Controller
public class StudentController {
	Logger logger = Logger.getLogger(StudentController.class);

	//@RequestMapping(value = ActionPaths.Student.studentAdmissionConfiguration, method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET, value = {
			ActionPaths.Student.studentAdmissionConfiguration,
			ActionPaths.Student.studentAdmissionConfiguration + "/AdmissionCategory"
	})
	public ModelAndView StudentAdmissionConfiguration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewNames.Student.studentAdmissionConfiguration);
		return mv;
	}

	@RequestMapping(value = ActionPaths.Student.studentManagement, method = RequestMethod.GET)
	public ModelAndView StudentManagement() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewNames.Student.studentManagement);
		return mv;
	}
}
