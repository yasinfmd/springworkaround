package com.myjavaapp.myapp.anotation;

import com.myjavaapp.myapp.anotation.imp.GenderValidationImp;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = GenderValidationImp.class)
@Documented
public @interface GenderValidator {
    String message() default "Hatalı değer izin verilen değerler MALE,FEMALE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
