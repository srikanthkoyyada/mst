package com.msb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.SchoolUser;

@Controller
public class SrichaitanyaPremium {

	@RequestMapping(value = "/srichaitanya/user/premium", method = RequestMethod.GET)
	public ModelAndView premium(HttpSession session) {
		
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());

	}

	@RequestMapping(value = "/srichaitanya/user/premium/articles", method = RequestMethod.GET)
	public ModelAndView articles(HttpSession session) {
		
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium/articles");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());

	}
	
	@RequestMapping(value = "/srichaitanya/user/premium/courses", method = RequestMethod.GET)
	public ModelAndView courses(HttpSession session) {

		
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium/courses");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());

	}

	@RequestMapping(value = "/srichaitanya/user/write-article", method = RequestMethod.GET)
	public ModelAndView writeArticle(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium/article-submit");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());

	}
	
	@RequestMapping(value = "/srichaitanya/user/premium/artscrafts", method = RequestMethod.GET)
	public ModelAndView crafts(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium/crafts");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());
	}
	
	@RequestMapping(value = "/srichaitanya/user/premium/music", method = RequestMethod.GET)
	public ModelAndView music(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			ModelAndView modelAndView = new ModelAndView();
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
			modelAndView.setViewName("/srichaitanya/premium/music");
			return modelAndView;
		} else
			return new ModelAndView("/srichaitanya/login", "user", new SchoolUser());
	}
	
	@RequestMapping(value = "/srichaitanya/user/get-premium", method = RequestMethod.GET)
	public String getpremium(ModelMap map) {
		return "/srichaitanya/premium/get-premium";
	}
	
}
