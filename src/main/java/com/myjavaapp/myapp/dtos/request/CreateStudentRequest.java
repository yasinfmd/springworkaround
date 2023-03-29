package com.myjavaapp.myapp.dtos.request;

import com.myjavaapp.myapp.anotation.DateValidator;
import com.myjavaapp.myapp.enums.Gender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateStudentRequest {
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Size(min = 3,message = "Min 3 karakter olmalı")

    private String name;

    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String lastName;

    @NotNull(message = "Null olamaz")
    private Gender gender;


    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Size(min = 10, message = "Geçerli bir tarih formatı giriniz izin verilen format dd.mm.yyyy")
    @DateValidator(pattern = "dd.mm.yyyy",message = "Geçerli bir tarih formatı giriniz izin verilen format dd.mm.yyyy")
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*    @NotNull(message = "Boş olamaz")
            @NotEmpty(message = "Bir değer giriniz")
            @DateTimeFormat(pattern = "dd.MM.yyyy")
            @Pattern(regexp = "dd.MM.yyyy", message = "Lütfen geçerli bir tarih formatı giriniz")
            private LocalDate age;*/
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Email(message = "Geçerli bir email giriniz")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

/*
    public Integer getAge() {
        LocalDate currentDate = LocalDate.now();
        int diff = Period.between(this.age, currentDate).getYears();
        return diff;
    }

    public void setAge(LocalDate age) {
        LocalDate currentDate = LocalDate.now();
        int diff = Period.between(age, currentDate).getYears();
        this.age = age;
    }
*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
