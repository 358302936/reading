package com.hx.reader.components.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<MinAndMaxValue,Integer>{

	private int minValue;
	
	private int maxValue;
	
	@Override
	public void initialize(MinAndMaxValue obj) {
		minValue=obj.minValue();
		maxValue=obj.maxValue();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {

		if(minValue<value && value<maxValue){
			return true;
		}else{
			String messageTemplate  =context.getDefaultConstraintMessageTemplate();
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("minValue");	
			context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
		}
		
		return false;
	}

	

}
