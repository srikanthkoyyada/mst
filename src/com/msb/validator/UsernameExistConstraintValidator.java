package com.msb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.msb.service.OtherService;

public class UsernameExistConstraintValidator implements
		ConstraintValidator<UsernameExistConstraint, Object> {

	@Autowired
	private OtherService otherService;

	@Override
	public void initialize(UsernameExistConstraint arg0) {
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
