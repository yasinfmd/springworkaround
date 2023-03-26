package com.myjavaapp.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + studentName + '\'' +
                ", lastName='" + studentLastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }




    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

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
    private Gender gender;


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


    @OneToOne(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private StudentDetail studentDetail;

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }



    public Student() {

    }

    public Student(UUID id, String studentName, String studentLastName, Gender gender, Integer age, String email) {
        this.id = id;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public enum Gender {
        MALE,
        FEMALE
    }
}