package com.myjavaapp.myapp.dao;


import com.myjavaapp.myapp.models.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao
{
    List<Student> getAllStudents();
    Optional<Student> getStudent(UUID uuid);

    int updateStudent(Student student);
    int removeStudent(UUID uuid);
    int createStudent(Student student);
}
