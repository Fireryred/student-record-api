package com.springframework.studentrecordapi.web.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.ExecutionError;
import com.springframework.studentrecordapi.service.StudentService;
import com.springframework.studentrecordapi.web.model.StudentBean;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<Object> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<StudentBean> getStudentById(@PathVariable String studentId)
            throws ExecutionError, ExecutionException, InterruptedException {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @GetMapping("/subjectCode/{subjectCode}")
    public ResponseEntity<Object> getStudentBySubjectCode(@PathVariable String subjectCode)
            throws ExecutionError, ExecutionException, InterruptedException {
        return new ResponseEntity<>(studentService.getStudentBySubjectCode(subjectCode), HttpStatus.OK);
    }
}
