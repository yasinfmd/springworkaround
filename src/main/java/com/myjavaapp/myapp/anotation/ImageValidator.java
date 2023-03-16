package com.myjavaapp.myapp.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ImageValidatorImp.class})
public @interface ImageValidator {
    String message() default "Only PNG or JPG images are allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
