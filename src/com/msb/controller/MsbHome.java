package com.msb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MsbHome {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		return "/index";
	}
	
}
