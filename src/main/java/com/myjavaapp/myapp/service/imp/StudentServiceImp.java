package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.response.StudentDto;
import com.myjavaapp.myapp.entity.Comment;
import com.myjavaapp.myapp.entity.Course;
import com.myjavaapp.myapp.entity.Student;
import com.myjavaapp.myapp.entity.StudentDetail;
import com.myjavaapp.myapp.enums.Gender;
import com.myjavaapp.myapp.repository.StudentRepository;
import com.myjavaapp.myapp.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void deneme() {
        Student student = new Student();
        student.setName(String.valueOf(new Random().nextInt()) + System.currentTimeMillis() / 1000);
        student.setGender(Gender.MALE);
        student.setEmail("qweeq@mail.com");
        student.setAge(33);
        student.setLastName("q");
        Comment c1 = new Comment();
        c1.setComment("Merhaba merhaba");
        Comment c2 = new Comment();
        c2.setComment("Yeni yorum yorum");

        Course c11 = new Course("Kurs1");
        Course c22 = new Course("Kurs2");
        student.getCourses().add(c11);
        student.getCourses().add(c22);


        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setDetailText("detay");

        student.getComments().add(c1);
        student.getComments().add(c2);
        c11.setStudent(student);
        c22.setStudent(student);

        student.setStudentDetail(studentDetail);
        studentDetail.setStudent(student);


        studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        try {
            List<Student> studentList = studentRepository.findAll();

            return studentList;
        } catch (Exception e) {
            throw e;
        }
    }
    public  void getStudentsByName(){
        try {
            var a=  this.studentRepository.findStudentByName("Y");
            var d=20;

        }catch (Exception e){
            System.out.print("q");
            throw  e;
        }
    }

    public  void getStudentsByAge(){
        try {
          var a=  this.studentRepository.findByAge(27);
            var d=20;

        }catch (Exception e){
            System.out.print("q");
            throw  e;
        }
    }


    @Override
    public StudentDto get(UUID studentId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı"));
            StudentDto dto = new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender());
            return dto;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Boolean delete(UUID studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new EntityNotFoundException("Kayıt bulunamadı");
        }
        this.studentRepository.delete(student);
        return true;
    }

    @Override
    public StudentDto create(CreateStudentRequest createStudentRequest) {
        Random random = new Random();
        int age= random.ints(20, 30)
                .findFirst()
                .getAsInt();
        Student student = new Student();
        student.setName(createStudentRequest.getName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setGender(createStudentRequest.getGender());
        //createStudentRequest.getAge()
        student.setAge(age);
        studentRepository.save(student);
        StudentDto dto = new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender());
        return dto;
    }
}
