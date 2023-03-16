package com.myjavaapp.myapp.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE ,ANNOTATION_TYPE,LOCAL_VARIABLE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NameValidatorImp.class})
public @interface NameValidator {
    String message() default "İsim hatası";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
