package com.myjavaapp.myapp.dtos.request;

import com.myjavaapp.myapp.anotation.DateValidator;
import com.myjavaapp.myapp.anotation.GenderValidator;
import com.myjavaapp.myapp.enums.Gender;
import jakarta.validation.constraints.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CreateStudentRequest {
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Size(min = 3,message = "Min 3 karakter olmalı")

    private String name;

    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String lastName;

    @NotNull(message = "Null olamaz")
    @GenderValidator(message ="FEMALE or MALE")
    private Gender gender;


    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Size(min = 10, message = "Geçerli bir tarih formatı giriniz izin verilen format dd.mm.yyyy")
    @DateValidator(pattern = "dd.mm.yyyy",message = "Geçerli bir tarih formatı giriniz izin verilen format dd.mm.yyyy")
    private String age;

    public int getAge() {
        try {
            Date today=new Date();
            Date birthDate=new SimpleDateFormat("dd.MM.yyyy").parse(this.age);
            long time_difference = today.getTime() - birthDate.getTime();
            return (int)(time_difference / (1000L*60*60*24*365));
        }catch (Exception e){
            return  0;
        }
    }

    public void setAge(String age) {
        this.age = age;
    }

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



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
