package com.msb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.msb.service.CollegeUserService;

public class CollegeUsernameExistConstraintValidator implements
		ConstraintValidator<CollegeUsernameExistConstraint, Object> {

	@Autowired
	private CollegeUserService otherService;

	@Override
	public void initialize(CollegeUsernameExistConstraint arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		String username = (String) arg0;
		if (otherService.isUserExist(username)) {
			System.out.println("Username already exist");
			return false;
		} else
			return true;
	}

}
