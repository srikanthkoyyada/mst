package com.msb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.msb.model.Other;

public class PasswordsEqualConstraintValidator implements
		ConstraintValidator<PasswordEqualConstraint, Object> {

	@Override
	public void initialize(PasswordEqualConstraint arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		Other other=(Other)arg0;
		System.out.println("password validator");
		System.out.println("\n password :"+other.getPassword());

		System.out.println("\n confirm password :"+other.getCpassword());
		return other.getPassword().equals(other.getCpassword());
	}

}
