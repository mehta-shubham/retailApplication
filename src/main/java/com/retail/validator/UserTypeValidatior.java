package com.retail.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.retail.annotation.ValidateUserType;

public class UserTypeValidatior implements ConstraintValidator<ValidateUserType,String>{

	List<String> userTypes = Arrays.asList("employee","affiliate","customer");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userTypes.contains(value);
	}

}
