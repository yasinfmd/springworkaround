package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.repository.StudentRepository;
import com.myjavaapp.myapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAll() {
        try{
            List<Student> studentList = studentRepository.findAll();
            return  studentList;
        }catch (Exception e){
                throw  e;
        }
    }

    @Override
    public Student get(Long studentId) {
        return null;
    }
}
