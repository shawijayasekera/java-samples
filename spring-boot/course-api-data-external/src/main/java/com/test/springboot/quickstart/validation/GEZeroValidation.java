package com.test.springboot.quickstart.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GEZeroValidation implements ConstraintValidator<GEZero, Double>{

	private static final String GE_ZERO_FORMAT = "^((\\d{1,}((\\.\\d{1,2})|(?!.))))$";
	
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		
		return String.valueOf(value).matches(GE_ZERO_FORMAT);
	}
}
