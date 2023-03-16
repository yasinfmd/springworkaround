package com.myjavaapp.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    private UUID userId;

    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String firstName;

    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String lastName;

    @NotNull(message = "Null olamaz")
    private Gender gender;


    @NotNull(message = "Boş olamaz")
    @Max(value = 100,message = "Max 100 olabilir")
    @Min(value = 0,message = "Min 0 olabilir")

    private Integer age;

    @NotNull(message = "Boş olamaz")
    @Email(message = "Geçerli bir email giriniz")
    private String email;


    public  String getFullName(){
        return  firstName + " - " + lastName;
    }

    @JsonProperty("birthYear")
    public int getDateOfBirth(){
        return  LocalDate.now().minusYears(age).getYear();
    }
    public Student(UUID userId, @JsonProperty("studentName") String firstName, @JsonProperty("studentLastName") String lastName, @JsonProperty("studentGender") Gender gender, @JsonProperty("studentAge") Integer age, @JsonProperty("studentEmail") String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public Student() {

    }

    @JsonProperty("studentId")
    public UUID getId() {
        return userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}