package com.msb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.CollegeUser;
import com.msb.model.Other;
import com.msb.model.SchoolUser;
import com.msb.service.CompetitionService;
import com.msb.service.QuizService;

@Controller
public class SrichaitanyaHome {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private CompetitionService competitionService;

	@RequestMapping(value = "/srichaitanya", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/srichaitanya/index";
	}

	@RequestMapping(value = "/srichaitanya/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		return "/srichaitanya/index";
	}	
	
	
	@RequestMapping(value = "/srichaitanya/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null)
			return new ModelAndView("/srichaitanya/index");
		else
			return new ModelAndView("/srichaitanya/login", "user", new Other());
	}

	@RequestMapping(value = "/srichaitanya/forgot", method = RequestMethod.GET)
	public ModelAndView forgotpwd(HttpSession session) {
		CollegeUser userData = (CollegeUser) session.getAttribute("CollegeStudent");
		if (userData != null)
			return new ModelAndView("/srichaitanya/index");
		else
			return new ModelAndView("/srichaitanya/frgtpwd");

	}
	
	@RequestMapping(value = "/srichaitanya/viewentries", method = RequestMethod.GET)
	public ModelAndView viewEntries() {
		return new ModelAndView("/srichaitanya/entries/view_entries");
	}
	
	@RequestMapping(value = "/srichaitanya/guidelines", method = RequestMethod.GET)
	public String guidelines(ModelMap map) {
		return "/srichaitanya/guidelines";
	}
	
	@RequestMapping(value = "/srichaitanya/aboutus", method = RequestMethod.GET)
	public ModelAndView aboutUs() {
		return new ModelAndView("/srichaitanya/aboutus");
	}
	
	@RequestMapping(value = "/srichaitanya/contactus", method = RequestMethod.GET)
	public ModelAndView contactUs() {
		return new ModelAndView("/srichaitanya/contactus");
	}
	
	/*
	 * @RequestMapping(value = "/srichaitanya/upload-a-talent", method =
	 * RequestMethod.GET) public ModelAndView uploadTalent() { return new
	 * ModelAndView("/srichaitanya/competitions/competitions"); }
	 */
	
}
