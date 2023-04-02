package com.myjavaapp.myapp.dtos.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDetailRequest {
    @Column(name = "detail")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
