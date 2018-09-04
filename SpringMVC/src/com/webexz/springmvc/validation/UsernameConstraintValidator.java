package com.webexz.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameConstraintValidator implements ConstraintValidator<Username, String>{
	private String prefix;
	
	@Override
	public void initialize(Username constraintAnnotation) {
		prefix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContex) {
		return code != null ? code.startsWith(prefix) : false;
	}
	
}
