package com.myjavaapp.myapp.service;

import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.response.StudentDto;
import com.myjavaapp.myapp.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    List<Student> getAll();

    StudentDto get(UUID studentId);

    Boolean delete(UUID studentId);


    StudentDto create(CreateStudentRequest student);

}
