package com.retail.validator;

import com.retail.annotation.IsEmpty;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyValidatior implements ConstraintValidator<IsEmpty,String>{


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !value.isEmpty();
		
	}

}
