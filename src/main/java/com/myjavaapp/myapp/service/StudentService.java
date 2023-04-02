package com.myjavaapp.myapp.service;

import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.request.StudentDetailRequest;
import com.myjavaapp.myapp.dtos.response.StudentDto;
import com.myjavaapp.myapp.entity.Student;
import com.myjavaapp.myapp.error.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    List<StudentDto> getAll();

    StudentDto get(UUID studentId);

    Boolean delete(UUID studentId);


    StudentDto create(CreateStudentRequest student);

    Boolean update(UUID studentId,CreateStudentRequest student);

    Boolean createStudentDetail(UUID studentId, StudentDetailRequest detail);

}
