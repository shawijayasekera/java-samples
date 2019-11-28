package com.test.springboot.quickstart.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MSISDNFormatValidator.class)
public @interface MSISDN {

	String message() default "Invalied msisdn";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
