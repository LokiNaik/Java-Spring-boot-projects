package com.validation.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomAnnotationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
	
	public String value() default "SQL";
	
	public String message() default "must start with SQL";
	
	public Class<?> [] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};

}
 