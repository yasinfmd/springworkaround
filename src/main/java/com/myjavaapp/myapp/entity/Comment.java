package com.myjavaapp.myapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "student_comments")
public class Comment extends BaseEntity {


    @Column(name = "comment")
    @NotNull(message = "Null olamaz")
    @NotEmpty(message = "Bir değer giriniz")
    @Size(min = 8,max = 200)
    private String comment;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
