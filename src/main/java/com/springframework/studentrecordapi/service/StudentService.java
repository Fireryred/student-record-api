package com.springframework.studentrecordapi.service;

import java.util.List;
import java.util.Map;

import com.springframework.studentrecordapi.web.model.StudentBean;

public interface StudentService {
    public List<StudentBean> getStudents();

    public List<Map<String, String>> getStudentById(String studentId);

    public List<Map<String, String>> getStudentBySubjectCode(String subjectCode);

    public List<StudentBean> getStudents(int page);

    public List<StudentBean> getSearchResult(String searchValue);
}
