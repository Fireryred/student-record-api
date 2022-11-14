package com.springframework.studentrecordapi.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.springframework.studentrecordapi.web.model.StudentBean;

public interface StudentService {
    public List<StudentBean> getStudents();

    public StudentBean getStudentById(String studentId) throws InterruptedException, ExecutionException;

    public List<StudentBean> getStudentBySubjectCode(String subjectCode)
            throws InterruptedException, ExecutionException;

}
