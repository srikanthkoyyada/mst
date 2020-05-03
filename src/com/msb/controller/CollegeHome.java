package com.msb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.CollegeUser;

@Controller
public class CollegeHome {

	@RequestMapping(value = "/college", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/college/index";
	}

	@RequestMapping(value = "/college/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		return "/college/index";
	}	
	
	
	@RequestMapping(value = "/college/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {

		CollegeUser userData = (CollegeUser) session.getAttribute("CollegeStudent");
		if (userData != null)
			return new ModelAndView("/college/index");
		else
			return new ModelAndView("/college/login", "user", new CollegeUser());
	}

	@RequestMapping(value = "/college/register", method = RequestMethod.GET)
	public ModelAndView register(HttpSession session) {
		CollegeUser userData = (CollegeUser) session.getAttribute("CollegeStudent");
		if (userData != null)
			return new ModelAndView("/college/index");
		else
			return new ModelAndView("/college/register", "user", new CollegeUser());
	}
	
	@RequestMapping(value = "/college/register/{refText}", method = RequestMethod.GET)
	public ModelAndView registerWithReferrence(HttpSession session, @PathVariable String refText) {
		CollegeUser userData = (CollegeUser) session.getAttribute("CollegeStudent");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("refText", refText);
		if (userData != null)
			return new ModelAndView("/college/index");
		else
			return new ModelAndView("/college/register", "user", new CollegeUser());
	}

	@RequestMapping(value = "/college/forgot", method = RequestMethod.GET)
	public ModelAndView forgotpwd(HttpSession session) {
		CollegeUser userData = (CollegeUser) session.getAttribute("CollegeStudent");
		if (userData != null)
			return new ModelAndView("/college/index");
		else
			return new ModelAndView("/college/frgtpwd");

	}

	@RequestMapping(value = "/college/register-landing", method = RequestMethod.GET)
	public ModelAndView registerSuccess() {

		return new ModelAndView("/college/register-landing");

	}
	
	@RequestMapping(value = "/college/viewentries", method = RequestMethod.GET)
	public ModelAndView viewEntries() {
		return new ModelAndView("/college/entries/view_entries");
	}
	
	/*
	 * @RequestMapping(value = "/college/upload-a-talent", method =
	 * RequestMethod.GET) public ModelAndView uploadTalent() { return new
	 * ModelAndView("/college/competitions/competitions"); }
	 */
	
}
