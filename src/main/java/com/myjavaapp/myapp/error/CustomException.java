package com.myjavaapp.myapp.error;

public class CustomException extends Exception {
    private String errorMessage;

    private int code;

    private long timestamp;

    private String endpoint;





    public CustomException(String errorMessage, int code, long timestamp) {
        this.errorMessage = errorMessage;
        this.code = code;
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }



}