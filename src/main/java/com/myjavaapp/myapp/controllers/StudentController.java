package com.myjavaapp.myapp.controllers;


import com.myjavaapp.myapp.anotation.ImageValidator;
import com.myjavaapp.myapp.configs.GeneralConfig;
import com.myjavaapp.myapp.configs.GlobalResponse;
import com.myjavaapp.myapp.dtos.BaseResponse;
import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.response.StudentDto;
import com.myjavaapp.myapp.entity.Student;
import com.myjavaapp.myapp.service.imp.StudentServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    // private FileStorageService storageService;

    private GlobalResponse globalResponse;

    private GeneralConfig generalConfig;

    @Autowired
    public StudentController(StudentServiceImp studentService, GeneralConfig generalConfig, GlobalResponse globalResponse) {
        //   this.storageService=storageService;
        // FileStorageService storageService,
        this.studentService = studentService;
        this.generalConfig = generalConfig;
        this.globalResponse = globalResponse;
        System.out.print(this.generalConfig.getApiPath());
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse<List<Student>>> getAllStudents() {
        globalResponse.getBaseResponse().setData(this.studentService.getAll());
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return ResponseEntity.ok().body(globalResponse.getBaseResponse());
    }

    @GetMapping("/{id}")
    public void getStudentById(@PathVariable(value = "id") UUID studentId) {
        System.out.print(studentId);
        // return this.studentService.getStudent(studentId).orElse(null);

    }

    @PostMapping(value = "/")
    public ResponseEntity<BaseResponse<StudentDto>> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        globalResponse.getBaseResponse().setData(this.studentService.create(createStudentRequest));
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<BaseResponse<StudentDto>>(globalResponse.getBaseResponse(), HttpStatus.CREATED);



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