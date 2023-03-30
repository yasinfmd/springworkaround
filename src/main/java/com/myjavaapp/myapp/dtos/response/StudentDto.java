package com.myjavaapp.myapp.dtos.response;


import com.myjavaapp.myapp.enums.Gender;

import java.util.UUID;

public class StudentDto {
    private UUID studentId;
    private String fullName;
    private  String  email;
    private int age;

    private String gender;


    public StudentDto(UUID studentId, String fullName, String email, int age, Gender gender) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.gender = gender.name();
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender.name();
    }
}
