package com.retail.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.retail.validator.EmptyDoubleValidator;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmptyDoubleValidator.class)
@Documented
public @interface IsDoubleEmpty {
	
	String message() default "Item Value cannot be alphabetic";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
