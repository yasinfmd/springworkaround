package com.myjavaapp.myapp.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyAppExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getError(MethodArgumentNotValidException exception, WebRequest request){
        // TODO bi çok özelliğine bak dosya kısımlarınada bak
        var code=exception.getStatusCode();
        Map<String,Object> errorResponse=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorResponse.put(fieldName, errorMessage);
        });
        errorResponse.put("path",request.getDescription(false));
        errorResponse.put("code",code);
        return  new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
    }
}

