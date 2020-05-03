package com.msb.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.BlogArticle;
import com.msb.model.CollegeUser;
import com.msb.model.Other;
import com.msb.model.SchoolUser;
import com.msb.model.SchoolUser.SaveUser;
import com.msb.service.CompetitionService;
import com.msb.service.QuizService;
import com.msb.service.SchoolUserService;
import com.msb.util.MsbUtil;
import com.msb.validator.SchoolRegisterValidator;

@Controller
public class SrichaitanyaAdmin {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	SchoolRegisterValidator registerValidator;
	
	@Autowired
	private SchoolUserService userService;
	
	@Autowired
	private CompetitionService competitionService;

	@RequestMapping(value = "/srichaitanya/admin/add-student", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/srichaitanya/admin/add-student";
	}

	
	@RequestMapping(value = "/srichaitanya/add-student", method = RequestMethod.POST)
	public String submitArticle(@ModelAttribute("user") SchoolUser other,
			HttpSession session, BindingResult result) {
			other.setPassword(other.getUsername());
			boolean isStudentSaved = userService.saveSchoolUser(other);
			if (isStudentSaved) {
				return "redirect:/srichaitanya/admin/add-student?success=true";
			} else
				return "redirect:/srichaitanya/admin/add-student?success=false";
	}
	
	/*
	 * @RequestMapping(value = "/srichaitanya/add-student", method =
	 * RequestMethod.POST) public String schoolUserRegister(
	 * 
	 * @ModelAttribute("user") @Validated({ SaveUser.class }) SchoolUser other,
	 * BindingResult result, HttpSession session) throws IOException {
	 * registerValidator.validate(other, result); if (!result.hasErrors()) {
	 * System.out.println("NO ERRORS"); String activation_code =
	 * MsbUtil.getActivationCode(); other.setActivation_code(activation_code);
	 * System.out.println("activation code set to user");
	 * other.setPassword(other.getUsername()); boolean isStudentSaved =
	 * userService.saveSchoolUser(other); System.out.println("student saved");
	 * String subject = "Thank You For The Registration on MySuperBrain"; if
	 * (isStudentSaved) { //String body =
	 * MsbUtil.buildStudentRegistrationMail1(other, //activation_code); //boolean
	 * isMailSent = mailService.sendMail(subject, body, //other.getMail(), false,
	 * //"MySuperBrain Account Activation"); //if (isMailSent) return
	 * "redirect:/srichaitanya/admin/add-student?success=true"; //else //return new
	 * ModelAndView( //"redirect:/others/register-landing?success=false"); } else
	 * return "redirect:/srichaitanya/admin/add-student?success=false"; } else {
	 * return "/srichaitanya/admin/add-student"; }
	 * 
	 * }
	 */
	
}
