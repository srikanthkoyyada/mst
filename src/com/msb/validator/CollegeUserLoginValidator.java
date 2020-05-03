package com.msb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.msb.model.CollegeUser;


@Component
public class CollegeUserLoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CollegeUser.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("in validator");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");

	}

}
