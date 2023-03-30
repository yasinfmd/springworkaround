package com.myjavaapp.myapp.anotation.imp;

import com.myjavaapp.myapp.anotation.GenderValidator;
import com.myjavaapp.myapp.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class GenderValidationImp  implements ConstraintValidator<GenderValidator,Gender> {
    @Override
    public boolean isValid(Gender value, ConstraintValidatorContext context) {
        for (Gender g : Gender.values()) {
            if (g.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
