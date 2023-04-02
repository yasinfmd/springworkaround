package com.myjavaapp.myapp.controllers;

import com.myjavaapp.myapp.configs.GlobalResponse;
import com.myjavaapp.myapp.dtos.BaseResponse;
import com.myjavaapp.myapp.service.imp.StudentDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("student-detail")

public class StudentDetailController {

    private StudentDetailServiceImp studentDetailService;

    private GlobalResponse globalResponse;


    @Autowired
    public StudentDetailController(StudentDetailServiceImp studentDetailService, GlobalResponse globalResponse) {
        this.studentDetailService = studentDetailService;
        this.globalResponse = globalResponse;
    }

    @DeleteMapping("/{id}")
    public   ResponseEntity<BaseResponse<Boolean>> deleteStudentDetail(@PathVariable("id") UUID studentDetailId){
        this.studentDetailService.delete(studentDetailId);
        globalResponse.getBaseResponse().setData(true);
        globalResponse.getBaseResponse().setCode(200);
        globalResponse.getBaseResponse().setStatus(true);
        globalResponse.getBaseResponse().setTime(System.currentTimeMillis());
        return new ResponseEntity(globalResponse.getBaseResponse(), HttpStatus.OK);


    }
}
