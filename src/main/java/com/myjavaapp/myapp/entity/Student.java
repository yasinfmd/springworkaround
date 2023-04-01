package com.myjavaapp.myapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myjavaapp.myapp.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends BaseEntity {
    @Column(name = "name")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String name;

    @Column(name = "lastName")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String lastName;

    @Column(name = "gender")
    @NotNull(message = "Null olamaz")
    private Gender gender;


    @Column(name = "age")
    @NotNull(message = "Boş olamaz")
    @Max(value = 100,message = "Max 100 olabilir")
    @Min(value = 0,message = "Min 0 olabilir")
    private Integer age;

    @Column(name = "email")
    @NotNull(message = "Boş olamaz")
    @Email(message = "Geçerli bir email giriniz")
    private String email;



    @JsonProperty("birthYear")
    public int getDateOfBirth(){
        return  LocalDate.now().minusYears(age).getYear();
    }

    @JsonIgnore
    @OneToOne(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private StudentDetail studentDetail;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Course> courses=new ArrayList<>();


    public Student() {
    }

    public Student(String name, String lastName, Gender gender, Integer age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

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

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}