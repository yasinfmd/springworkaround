package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.request.StudentDetailRequest;
import com.myjavaapp.myapp.dtos.response.StudentDetailDto;
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
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender())).collect(Collectors.toList());

    }

    public List<StudentDto> getStudentsByName(String name) {
        List<Student> students = this.studentRepository.findStudentByName(name);
        return students.stream().map((student) -> new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender())).collect(Collectors.toList());
    }

    public List<StudentDto> getStudentsByAge(int age) {
        List<Student> students = this.studentRepository.findByAge(age);
        return students.stream().map((student) -> new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender())).collect(Collectors.toList());

    }


    @Override
    public StudentDto get(UUID studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı"));
        student.getComments().get(0);
        return new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender());


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
        Student student = new Student();
        student.setName(createStudentRequest.getName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setGender(createStudentRequest.getGender());
        student.setAge(createStudentRequest.getAge());
        studentRepository.save(student);
        return new StudentDto(student.getId(), student.getName() + " " + student.getLastName(), student.getEmail(), student.getAge(), student.getGender());
    }

    @Override
    public Boolean update(UUID studentId, CreateStudentRequest updateStudent) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new EntityNotFoundException("Kayıt bulunamadı");
        }
        student.setName(updateStudent.getName());
        student.setLastName(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());
        student.setGender(updateStudent.getGender());
        student.setAge(updateStudent.getAge());
        studentRepository.save(student);
        return true;
    }

    @Override
    @Transactional
    public Boolean createStudentDetail(UUID studentId, StudentDetailRequest detail) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new EntityNotFoundException("Kayıt bulunamadı");
        }
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setDetailText(detail.getDetail());
        student.setStudentDetail(studentDetail);
        studentDetail.setStudent(student);
        studentRepository.save(student);
        return true;

    }

    @Override
    public StudentDetailDto getStudentDetail(UUID studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new EntityNotFoundException("Kayıt bulunamadı");
        }
        StudentDetail detail = student.getStudentDetail();
        return new StudentDetailDto(detail.getId(), detail.getDetailText());
    }
}
