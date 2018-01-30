/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

/**
 *
 * @author LS5002117
 */


import model.FoodItem;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class FoodItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FoodItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "type.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "veg", "veg.required");
                System.out.println("TESTING KDF");
		FoodItem fitem = (FoodItem) target;	
                if(fitem.getName().length() > 10){
                    errors.rejectValue("name","nametolong");
                }
			
	}

}

