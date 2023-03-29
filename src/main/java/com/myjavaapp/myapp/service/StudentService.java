package com.myjavaapp.myapp.service;

import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student get(Long studentId);

    Student create(CreateStudentRequest student);

}
