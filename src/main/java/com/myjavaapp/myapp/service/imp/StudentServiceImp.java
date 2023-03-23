package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.models.StudentDetail;
import com.myjavaapp.myapp.repository.StudentRepository;
import com.myjavaapp.myapp.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void deneme(){
        Student employee = new Student();
        employee.setStudentName("qq");
        employee.setGender(Student.Gender.MALE);
        employee.setEmail("qweeq@mail.com");
        employee.setAge(33);
        employee.setStudentLastName("q");

        StudentDetail employeeDetail = new StudentDetail();
        employeeDetail.setDetailText("detay");

        employee.setStudentDetail(employeeDetail);
        employeeDetail.setStudent(employee);
        studentRepository.save(employee);
    }
    @Override
    public List<Student> getAll() {
        try{
            List<Student> studentList = studentRepository.findAll().stream().map(item->{
                item.setStudentDetail(item.getStudentDetail());
                return  item;
            }).collect(Collectors.toList());
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
