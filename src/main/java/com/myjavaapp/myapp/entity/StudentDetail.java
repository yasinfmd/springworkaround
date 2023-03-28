package com.myjavaapp.myapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "student_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDetail extends BaseEntity {



    @JsonIgnore
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name = "detail")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    private String detailText;


    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public  StudentDetail(){

    }


    public StudentDetail(String detailText) {
        this.detailText = detailText;
    }
}
