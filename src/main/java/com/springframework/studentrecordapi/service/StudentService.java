package com.springframework.studentrecordapi.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.springframework.studentrecordapi.web.model.StudentBean;

public interface StudentService {
    public StudentBean getStudentByOid(String oid) throws InterruptedException, ExecutionException;

    public StudentBean getStudentById(String studentId) throws InterruptedException, ExecutionException;

    public List<String> getStudentBySubjectCode(String subjectCode)
            throws InterruptedException, ExecutionException;
}
