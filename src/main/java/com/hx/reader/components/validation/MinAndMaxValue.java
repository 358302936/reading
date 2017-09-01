package com.hx.reader.components.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=Validator.class)
public @interface MinAndMaxValue {

	String message() default "{超过了范围要求}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {}; 
	
	//最小值
	int minValue();
	//最大值
	int maxValue();
}
