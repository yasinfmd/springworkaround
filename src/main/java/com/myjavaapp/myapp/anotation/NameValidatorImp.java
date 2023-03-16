package com.myjavaapp.myapp.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class NameValidatorImp implements ConstraintValidator<NameValidator, Map> {
    @Override
    public boolean isValid(Map value, ConstraintValidatorContext context) {
        return false;
    }
}
