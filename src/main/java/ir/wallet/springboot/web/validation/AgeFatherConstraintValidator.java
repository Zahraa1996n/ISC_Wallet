package ir.wallet.springboot.web.validation;

import ir.wallet.springboot.persistence.model.Gender;
import ir.wallet.springboot.persistence.model.Person;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeFatherConstraintValidator implements ConstraintValidator<AgeFatherConstraint, Person> {


	public boolean isValid(Person person, ConstraintValidatorContext context) {
        if (person.getAge() < 18) {
            if (person.getFatherCode() == null || person.getFatherCode().trim().isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("If age is less than 18, fatherCode must be provided.")
                        .addConstraintViolation();
                return false;  
            }
        } 
        
        else {
        	Gender gender = person.getGender();
            
            
            if (Gender.MALE.equals(gender)) { 
                if (person.getTrooper() == null || person.getTrooper().trim().isEmpty()) {
                	context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("If age is 18 or older and gender is male, trooper status must be provided.")
                            .addConstraintViolation();
                    return false;  
                }
            }
        }

        
        return true;
    }  
	
    }


