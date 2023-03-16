package com.myjavaapp.myapp.service;

import com.myjavaapp.myapp.dao.StudentDao;
import com.myjavaapp.myapp.models.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private  final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return  this.studentDao.getAllStudents();
    }

    public Optional<Student> getStudent(UUID uuid) {
        return   this.studentDao.getStudent(uuid);
    }

    public int updateStudent(Student student) {
        Optional<Student> studentOptional=getStudent(student.getId());
        if(studentOptional.isPresent()){
              this.studentDao.updateStudent(student);
              return  1;
        }
        return  -1;
    }

    public int removeStudent(UUID uuid) {
        Optional<Student> studentOptional=getStudent(uuid);
        if(studentOptional.isPresent()){
              this.studentDao.removeStudent(uuid);
            return  1;
        }
        return  -1;
    }

    public int createStudent(@Valid Student student) {
        try {
           return this.studentDao.createStudent(student);
        }catch (Exception e){
            System.out.print("qweqweqw");
                throw  e;
        }
    }
}
