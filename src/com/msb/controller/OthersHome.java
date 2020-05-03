package com.msb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.Other;
import com.msb.service.CompetitionService;
import com.msb.service.QuizService;

@Controller
public class OthersHome {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private CompetitionService competitionService;

	@RequestMapping(value = "/others", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/others/index";
	}

	@RequestMapping(value = "/others/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		return "/others/index";
	}	
	
	
	@RequestMapping(value = "/others/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {

		Other userData = (Other) session.getAttribute("Other");
		if (userData != null)
			return new ModelAndView("/others/index");
		else
			return new ModelAndView("/others/login", "user", new Other());
	}

	@RequestMapping(value = "/others/register", method = RequestMethod.GET)
	public ModelAndView register(HttpSession session) {
		Other userData = (Other) session.getAttribute("Other");
		if (userData != null)
			return new ModelAndView("/others/index");
		else
			return new ModelAndView("/others/register", "user", new Other());
	}
	
	@RequestMapping(value = "/others/register/{refText}", method = RequestMethod.GET)
	public ModelAndView registerWithReferrence(HttpSession session, @PathVariable String refText) {
		Other userData = (Other) session.getAttribute("Other");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("refText", refText);
		if (userData != null)
			return new ModelAndView("/others/index");
		else
			return new ModelAndView("/others/register", "user", new Other());
	}

	@RequestMapping(value = "/others/forgot", method = RequestMethod.GET)
	public ModelAndView forgotpwd(HttpSession session) {
		Other userData = (Other) session.getAttribute("Other");
		if (userData != null)
			return new ModelAndView("/others/index");
		else
			return new ModelAndView("/others/frgtpwd");

	}

	@RequestMapping(value = "/others/register-landing", method = RequestMethod.GET)
	public ModelAndView registerSuccess() {

		return new ModelAndView("/others/register-landing");

	}
	
	@RequestMapping(value = "/others/viewentries", method = RequestMethod.GET)
	public ModelAndView viewEntries() {
		return new ModelAndView("/others/entries/view_entries");
	}
	
	/*
	 * @RequestMapping(value = "/others/upload-a-talent", method =
	 * RequestMethod.GET) public ModelAndView uploadTalent() { return new
	 * ModelAndView("/others/competitions/competitions"); }
	 */
	
}
