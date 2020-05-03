package com.msb.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SchoolUsernameExistConstraintValidator.class)
public @interface SchoolUsernameExistConstraint {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
