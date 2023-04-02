package com.myjavaapp.myapp.repository;

import com.myjavaapp.myapp.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, UUID> {
}
