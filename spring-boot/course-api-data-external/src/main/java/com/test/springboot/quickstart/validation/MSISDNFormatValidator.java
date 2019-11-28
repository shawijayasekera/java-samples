package com.test.springboot.quickstart.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MSISDNFormatValidator implements ConstraintValidator<MSISDN, String> {

	private static final String MSISDN_FORMAT = "^((((tel:){1}(\\+){0,1})|((tel:){0,1}(\\+){1}))([a-zA-Z0-9]+))$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return value.matches(MSISDN_FORMAT);
	}
}
