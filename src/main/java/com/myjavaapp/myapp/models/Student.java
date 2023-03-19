package com.myjavaapp.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + studentName + '\'' +
                ", lastName='" + studentLastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }



    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int studentId;

    @Column(name = "student_name")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String studentName;

    @Column(name = "student_last_name")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String studentLastName;

    @Column(name = "student_gender")
    @NotNull(message = "Null olamaz")
    private String gender;


    @Column(name = "student_age")
    @NotNull(message = "Boş olamaz")
    @Max(value = 100,message = "Max 100 olabilir")
    @Min(value = 0,message = "Min 0 olabilir")

    private Integer age;

    @Column(name = "student_mail")
    @NotNull(message = "Boş olamaz")
    @Email(message = "Geçerli bir email giriniz")
    private String email;


    public  String getFullName(){
        return  studentName + " - " + studentLastName;
    }

    @JsonProperty("birthYear")
    public int getDateOfBirth(){
        return  LocalDate.now().minusYears(age).getYear();
    }


    public Student() {

    }

    public Student(int studentId, String studentName, String studentLastName, String gender, Integer age, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}