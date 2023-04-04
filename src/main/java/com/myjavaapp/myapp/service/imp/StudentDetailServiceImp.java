package com.myjavaapp.myapp.service.imp;

import com.myjavaapp.myapp.entity.Student;
import com.myjavaapp.myapp.entity.StudentDetail;
import com.myjavaapp.myapp.repository.StudentDetailRepository;
import com.myjavaapp.myapp.service.StudentDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentDetailServiceImp implements StudentDetailService {
    private final StudentDetailRepository studentDetailRepository;

    @Autowired
    public StudentDetailServiceImp(StudentDetailRepository studentDetailRepository) {
        this.studentDetailRepository = studentDetailRepository;
    }


    @Override
    public Boolean delete(UUID detailId) {
        StudentDetail studentDetail = this.studentDetailRepository.findById(detailId).orElse(null);
        if (studentDetail == null) {
            throw new EntityNotFoundException("Kayıt bulunamadı");
        }
        Student s = studentDetail.getStudent();
        s.setStudentDetail(null);
        studentDetail.setStudent(null);
        this.studentDetailRepository.deleteById(detailId);
        return true;
    }
}
