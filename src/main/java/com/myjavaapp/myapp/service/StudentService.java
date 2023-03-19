package com.myjavaapp.myapp.service;

import com.myjavaapp.myapp.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student get(Long studentId);

}
