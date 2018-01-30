/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

/**
 *
 * @author LS5002117
 */


import model.Availability;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class AvailabilityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Availability.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "zipcode.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "meal", "meal.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "start_date", "start.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "end_date", "end.required");
                	
	}

}

