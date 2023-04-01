package com.myjavaapp.myapp.repository;

import com.myjavaapp.myapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
/*        @Query("SELECT s FROM student u WHERE s.age = ?1")
        List<Student> findStudentByAge(Integer age);*/

/*        @Query("SELECT s FROM student u WHERE s.age = ?1")
        List<Student> findStudentByAge(int age);*/

   /*     @Query(value = "SELECT s FROM student s WHERE  s.age = :age",nativeQuery = true)
        Student findByAge(@Param("age") Integer age);*/


/*        @Query(value = "SELECT s FROM Student s WHERE s.name='test'",nativeQuery = true)
        List<Student> findStudentByAge(@Param("name") String name);*/

        @Query("FROM Student WHERE age = ?1")
        List<Student> findByAge(Integer age);

        @Query(value = "SELECT * FROM Student WHERE name = :name", nativeQuery = true)
        List<Student> findStudentByName(@Param("name") String name);
}
