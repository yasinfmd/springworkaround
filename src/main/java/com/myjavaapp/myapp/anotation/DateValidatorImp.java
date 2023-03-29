package com.myjavaapp.myapp.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidatorImp implements ConstraintValidator<DateValidator,String> {


    private String pattern;


    @Override
    public void initialize(DateValidator constraintAnnotation) {
        this.pattern=constraintAnnotation.pattern();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            Date date = new SimpleDateFormat(pattern).parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

