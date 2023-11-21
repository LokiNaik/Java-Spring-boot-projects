package com.validation.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomAnnotationValidator implements ConstraintValidator<CustomAnnotation, String> {

	private String codePrefix;
	@Override
	public void initialize(CustomAnnotation constraintAnnotation) {
		codePrefix = constraintAnnotation.value();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		boolean result;
		
		if(value != null) {
			result = value.startsWith(codePrefix);
		}
		else {
			result = true;
		}
		return result;
	}

	
}
