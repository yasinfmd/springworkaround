package com.myjavaapp.myapp.dtos.request;

import com.myjavaapp.myapp.enums.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

public class CreateStudentRequest {
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String name;

    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String lastName;

    @NotNull(message = "Null olamaz")
    private Gender gender;




    @NotNull(message = "Boş olamaz")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate age;
    @NotNull(message = "Boş olamaz")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
