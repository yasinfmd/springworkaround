package com.myjavaapp.myapp.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;
import java.util.*;

@RestControllerAdvice
public class MyAppExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getError(MethodArgumentNotValidException exception, WebRequest request) {
        HttpStatusCode statusCode = exception.getStatusCode();
        Map<String, Object> errorResponse = new HashMap<>();
        List<Map<String, Set<String>>> errorList = new ArrayList<>();

        Map<String, Set<String>> validationErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            Set<String> errorMessages=new LinkedHashSet<>();
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            if(validationErrors.get(fieldName) != null){
                validationErrors.get(fieldName).add(errorMessage);
            }else{
                errorMessages.add(errorMessage);
                validationErrors.put(fieldName,errorMessages);
            }
        });
        errorList.add(validationErrors);
        errorResponse.put("dateTime", new Date().getTime());
        errorResponse.put("errorList", errorList);
        errorResponse.put("code", statusCode.value());
        errorResponse.put("endpoint", request.getDescription(false));
        errorResponse.put("success", false);
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), statusCode.value());
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<Object> getError(MultipartException exception,WebRequest request) throws IOException {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", exception.getMessage());
        errorResponse.put("code", 500);
        errorResponse.put("timeStamp", new Date().getTime());
        errorResponse.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), 500);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> getError(CustomException exception, WebRequest request) {
        exception.setEndpoint(request.getDescription(true));
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", exception.getErrorMessage());
        errorResponse.put("code", exception.getCode());
        errorResponse.put("timeStamp", exception.getTimestamp());
        errorResponse.put("path", exception.getEndpoint());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), exception.getCode());
    }

    @ExceptionHandler
    public ResponseEntity<Object> getError(Exception exception, WebRequest request) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", exception.getMessage());
        errorResponse.put("code", 500);
        errorResponse.put("timeStamp", new Date().getTime());
        errorResponse.put("path", request.getDescription(false));
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), 500);
    }
}