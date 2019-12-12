package com.retail.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.retail.validator.UserTypeValidatior;

/**
 * validates user type in request body while creating user
 * @author shubham.mehta
 *
 */
@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserTypeValidatior.class)
@Documented
public @interface ValidateUserType {
	String message() default "Possible User Types values are 'employee', 'affiliate', 'customer'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
