package com.myjavaapp.myapp.controllers;


import com.myjavaapp.myapp.anotation.ImageValidator;
import com.myjavaapp.myapp.configs.GlobalResponse;
import com.myjavaapp.myapp.dtos.BaseResponse;
import com.myjavaapp.myapp.dtos.request.CreateStudentRequest;
import com.myjavaapp.myapp.dtos.request.StudentDetailRequest;
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

    private GlobalResponse globalResponse;


    @Autowired
    public StudentController(StudentServiceImp studentService, GlobalResponse globalResponse) {
        this.studentService = studentService;
        this.globalResponse = globalResponse;
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
    public ResponseEntity<BaseResponse<StudentDto>> getStudentById(@PathVariable(value = "id") UUID studentId) {
        globalResponse.getBaseResponse().setData(this.studentService.get(studentId));
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<BaseResponse<StudentDto>>(globalResponse.getBaseResponse(), HttpStatus.OK);
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
    public ResponseEntity<BaseResponse<Boolean>> deleteStudent(@PathVariable(value = "id") UUID studentId) {
        this.studentService.delete(studentId);
        globalResponse.getBaseResponse().setData(true);
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity(globalResponse.getBaseResponse(), HttpStatus.OK);

    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<Boolean>> updateStudent(@PathVariable(value = "id") UUID studentId,@Valid  @RequestBody CreateStudentRequest student) {
        this.studentService.update(studentId,student);
        globalResponse.getBaseResponse().setData(true);
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<>(globalResponse.getBaseResponse(), HttpStatus.OK);

    }

    @GetMapping("/getByName")
    public ResponseEntity<BaseResponse<List<StudentDto>>> getByName(@RequestParam("name") String name) {
        globalResponse.getBaseResponse().setData(this.studentService.getStudentsByName(name));
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<>(globalResponse.getBaseResponse(), HttpStatus.OK);
    }

    @GetMapping("/getByAge")
    public ResponseEntity<BaseResponse<List<StudentDto>>> getByAge(@RequestParam("age") String age) {
        globalResponse.getBaseResponse().setData(this.studentService.getStudentsByAge(Integer.valueOf(age)));
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<>(globalResponse.getBaseResponse(), HttpStatus.OK);
    }


    @PostMapping(value = "/{id}/detail")
    public ResponseEntity<BaseResponse<Boolean>>  createStudentDetail(@PathVariable(value = "id") UUID studentId,@Valid @RequestBody  StudentDetailRequest studentDetailRequest){
        this.studentService.createStudentDetail(studentId,studentDetailRequest);
        globalResponse.getBaseResponse().setData(true);
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity<>(globalResponse.getBaseResponse(), HttpStatus.OK);
    }


    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //@Valid @RequestPart("data") Student student,
    public String createStudentWithFile(@ImageValidator @RequestPart("file") MultipartFile file
    ) {
        return "qq";
    }


}