package com.myjavaapp.myapp.controllers;


import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    public StudentController(StudentService service) {
        this.studentService=service;
    }

    @GetMapping("/getAll")
    public List<Student> GetAllStudents (){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public  Optional<Student> getStudentById (@PathVariable(value = "id") UUID studentId){
        System.out.print(studentId);
        return this.studentService.getStudent(studentId);
    }

    @PostMapping(value = "/createStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createStudent(@Valid @RequestBody  Student student){
        try {
            var result= studentService.createStudent(student);
            if(result==1){
                return  ResponseEntity.ok().build();
            }
            return  ResponseEntity.badRequest().build();
        }catch (Exception e){
            System.out.print("qqq");
            return  ResponseEntity.badRequest().build();

        }

    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable(value = "id") UUID studentId){
        var result= studentService.removeStudent(studentId);
        if(result==1){
            return  ResponseEntity.ok().build();
        }
        return  ResponseEntity.badRequest().build();

    }


    @PutMapping(value = "/updateStudent/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateStudent(@PathVariable(value = "id") UUID studentId,@RequestBody Student student){
        var result= studentService.updateStudent(student);
        if(result==1){
            return  ResponseEntity.ok().build();
        }
        return  ResponseEntity.badRequest().build();

    }

    @GetMapping("/getByQuery")
    public  String getQp(@RequestParam("q") String q){
        return  "";
    }

    public  List<Student> getFilteredMock(){
        var list=this.studentService.getAllStudents();
        var filteredList2=list.stream().filter(student -> student.getFirstName().equals("yasin")).collect(Collectors.toList());
        var filteredList=list.stream().filter(student -> {
           return student.getFirstName().equals("yasin");
        }).collect(Collectors.toList());
        return  filteredList;
    }

    @PostMapping(value = "/jacksonpost")
    public  void JacksonData(){

    }
}

