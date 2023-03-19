package com.myjavaapp.myapp.controllers;


import com.myjavaapp.myapp.anotation.ImageValidator;
import com.myjavaapp.myapp.configs.GeneralConfig;
import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.service.imp.FileStorageService;
import com.myjavaapp.myapp.service.imp.StudentServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/student")
@Validated
public class StudentController {
    private StudentServiceImp studentService;
    private FileStorageService storageService;

    private GeneralConfig generalConfig;

    @Autowired
    public StudentController(StudentServiceImp studentService, FileStorageService storageService, GeneralConfig generalConfig) {
        this.storageService=storageService;
        this.studentService = studentService;
        this.generalConfig=generalConfig;
        System.out.print(this.generalConfig.getApiPath());
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return this.studentService.getAll();
    }

    @GetMapping("/getStudent/{id}")
    public void getStudentById(@PathVariable(value = "id") UUID studentId) {
        System.out.print(studentId);
       // return this.studentService.getStudent(studentId).orElse(null);

    }

    @PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createStudent(@Valid @RequestBody Student student) {
     /*   try {
            var result = studentService.createStudent(student);
            if (result == 1) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.print("qqq");
            return ResponseEntity.badRequest().build();

        }*/
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable(value = "id") UUID studentId) {
    /*    var result = studentService.removeStudent(studentId);
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();*/
        return ResponseEntity.ok().build();


    }


    @PutMapping(value = "/updateStudent/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateStudent(@PathVariable(value = "id") UUID studentId, @RequestBody Student student) {
   /*     var result = studentService.updateStudent(student);
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();*/
        return ResponseEntity.ok().build();

    }

    @GetMapping("/getByQuery")
    public String getQp(@RequestParam("q") String q) {
        return "";
    }

    public void getFilteredMock() {
   /*     var list = this.studentService.getAllStudents();
        var filteredList2 = list.stream().filter(student -> student.getStudentName().equals("yasin")).collect(Collectors.toList());
        var filteredList = list.stream().filter(student -> {
            return student.getStudentName().equals("yasin");
        }).collect(Collectors.toList());
        return filteredList;*/

    }

    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //@Valid @RequestPart("data") Student student,
    public String createStudentWithFile(@ImageValidator @RequestPart("file") MultipartFile file
    ) {
        return "qq";
    }


    @PostMapping(value = "/jacksonpost")
    public void JacksonData() {

    }
}