package com.myjavaapp.myapp.dao;

import com.myjavaapp.myapp.models.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDaoImp  implements  StudentDao{
    private static Map<UUID, Student> _db;
    static {
        _db=new HashMap<>();
        UUID studentId=UUID.randomUUID();
        _db.put(studentId,new Student(studentId,"Yasin","Dalkılıç", Student.Gender.MALE,27,"yasin@mail.com"));
    }
    @Override
    public List<Student> getAllStudents() {
        return  new ArrayList<>(_db.values());
    }

    @Override
    public Optional<Student> getStudent(UUID uuid) {
        return   Optional.ofNullable(_db.get(uuid));
    }

    @Override
    public int updateStudent(Student student) {
        _db.put(student.getId(),student);
        return 1;
    }

    @Override
    public int removeStudent(UUID uuid) {
        _db.remove(uuid);
        return 1;
    }

    @Override
    public int createStudent(Student student) {
      try {
          UUID newid=UUID.randomUUID();
          student.setUserId(newid);
          _db.put(newid,student);
          return 1;
      }
      catch (Exception e){
          throw  e;
      }
    }
}
