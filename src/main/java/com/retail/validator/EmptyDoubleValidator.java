package com.retail.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.retail.annotation.IsEmpty;

public class EmptyDoubleValidator implements ConstraintValidator<IsEmpty,Double>{

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		return !value.isNaN();
	}

}
