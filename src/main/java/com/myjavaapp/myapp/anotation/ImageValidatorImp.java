package com.myjavaapp.myapp.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageValidatorImp implements ConstraintValidator<ImageValidator, MultipartFile> {

    @Override
    public void initialize(ImageValidator constraintAnnotation) {
        System.out.print("bende");
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        boolean result = true;
        String contentType = multipartFile.getContentType();
        if (!isSupportedContentType(contentType)) {
            result = false;
        }

        return false;

    }

    private boolean isSupportedContentType(String contentType) {
        return  contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }
}
