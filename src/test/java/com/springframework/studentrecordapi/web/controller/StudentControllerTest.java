package com.springframework.studentrecordapi.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.repository.ClassDetailsRepository;
import com.springframework.studentrecordapi.repository.StudentRepository;
import com.springframework.studentrecordapi.service.StudentService;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentRepository sRepository;

    @MockBean
    ClassDetailsRepository cRepository;

    @MockBean
    StudentService studentService;

    @Test
    void testGetStudentById() throws Exception {
        Iterator<Student> students = sRepository.findAll().iterator();
        while (students.hasNext()) {
            String id = students.next().getStudent_id();
            mockMvc.perform(get("/api/v1/student/studentId/" + id)).andExpect(status().isOk());
        }
    }

    @Test
    void testGetStudentBySubjectCode() throws Exception {
        Iterator<String> codes = cRepository.getAllSubjectCode().iterator();
        while (codes.hasNext()) {
            String code = codes.next();
            mockMvc.perform(get("/api/v1/student/subjectCode/" + code)).andExpect(status().isOk());
        }
    }

    @Test
    void testGetStudents() throws Exception {
        mockMvc.perform(get("/api/v1/student/list")).andExpect(status().isOk());
    }
}
