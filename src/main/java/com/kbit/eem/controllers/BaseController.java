package com.kbit.eem.controllers;

public class BaseController {
	public BaseController() {
	}

	public String getRedirectView(String viewName) {
		return "redirect:" + viewName;
	}
}