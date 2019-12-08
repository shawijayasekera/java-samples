package com.test.springboot.quickstart.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GTZeroValidation implements ConstraintValidator<GTZero, Double> {

	private static final String GT_ZERO_FORMAT = "^(([1-9][0-9]+|[1-9])+(\\.[0-9]+)?)$";

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {

		return String.valueOf(value).matches(GT_ZERO_FORMAT);
	}
}
