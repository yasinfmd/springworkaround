package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.models.Comment;
import com.myjavaapp.myapp.models.Course;
import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.models.StudentDetail;
import com.myjavaapp.myapp.repository.StudentRepository;
import com.myjavaapp.myapp.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Student student = new Student();
        student.setStudentName("qq");
        student.setGender(Student.Gender.MALE);
        student.setEmail("qweeq@mail.com");
        student.setAge(33);
        student.setStudentLastName("q");
        Comment c1=new Comment();
        c1.setComment("Merhaba merhaba");
        Comment c2=new Comment();
        c2.setComment("Yeni yorum yorum");

        Course c11=new Course("Kurs1");
        Course c22=new Course("Kurs2");
        student.getCourses().add(c11);
        student.getCourses().add(c22);


        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setDetailText("detay");

        student.getComments().add(c1);
        student.getComments().add(c2);


        student.setStudentDetail(studentDetail);
     //   studentDetail.setStudent(student);


        studentRepository.save(student);
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
