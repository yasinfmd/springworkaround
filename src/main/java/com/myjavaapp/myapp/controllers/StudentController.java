package com.myjavaapp.myapp.controllers;


import com.myjavaapp.myapp.anotation.ImageValidator;
import com.myjavaapp.myapp.configs.GeneralConfig;
import com.myjavaapp.myapp.models.Student;
import com.myjavaapp.myapp.service.imp.FileStorageService;
import com.myjavaapp.myapp.service.imp.StudentServiceImp;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


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

    @GetMapping("/")
    @Transactional
    public List<Student> getAllStudents() {
        this.studentService.deneme();
        return this.studentService.getAll();
    }

    @GetMapping("/{id}")
    public void getStudentById(@PathVariable(value = "id") UUID studentId) {
        System.out.print(studentId);
       // return this.studentService.getStudent(studentId).orElse(null);

    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable(value = "id") UUID studentId) {
        return ResponseEntity.ok().build();


    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateStudent(@PathVariable(value = "id") UUID studentId, @RequestBody Student student) {
        return ResponseEntity.ok().build();

    }

    @GetMapping("/getByQuery")
    public String getQp(@RequestParam("q") String q) {
        return "";
    }


    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //@Valid @RequestPart("data") Student student,
    public String createStudentWithFile(@ImageValidator @RequestPart("file") MultipartFile file
    ) {
        return "qq";
    }



}