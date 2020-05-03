package com.msb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.msb.model.Other;
import com.msb.service.OtherService;

@Component
public class RegisterValidator implements Validator {
	
	@Autowired
	private OtherService otherService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Other.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Other other = (Other) target;
		/*System.out.println(user.getDob());
		System.out.println("in reg validator");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guardian",
				"gaurdian.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail",
				"mail.required");
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpassword",
				"cpassword.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "school",
				"school.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "standard",
				"class.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "section",
				"section.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"mobile.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
				"country.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
				"state.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
				"city.required");*/
		/*
		 * if (!user.getPassword().equals(user.getCpassword())) {
		 * System.out.println("passwords not matching");
		 * 
		 * errors.rejectValue("cpassword", "password.missmatch"); }
		 */
		/*
		 * if(otherService.isUserExist(user.getUsername())){
		 * System.out.println("username exist");
		 * 
		 * errors.rejectValue("username", "username.exist"); }
		 * if(user.getImage()!=null && user.getImage().length>0){
		 * System.out.println("file size is "+user.getImage().length/1024);
		 * 
		 * }
		 */

	}	
	
	public void validate1(Object target, Errors errors) {

		Other user1 = (Other) target;
		
		if (!user1.getPassword().equals(user1.getCpassword())) {
			System.out.println("passwords matching");
		
			errors.rejectValue("cpassword", "password.missmatch");
		}		

	}
	
	/*public void validate(Object target, Errors errors) {

		Other user = (Other) target;
		
		if (!user.getPassword().equals(user.getCpassword())) {
			System.out.println("passwords matching");
		
			errors.rejectValue("cpassword", "password.missmatch");
		}		

	}*/
	

}
