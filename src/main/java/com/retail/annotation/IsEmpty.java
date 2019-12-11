package com.retail.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.retail.validator.EmptyValidatior;

@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmptyValidatior.class)
@Documented
public @interface IsEmpty {
	
	String message() default "Name cannot be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
