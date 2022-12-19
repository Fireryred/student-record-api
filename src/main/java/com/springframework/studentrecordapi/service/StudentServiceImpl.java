package com.springframework.studentrecordapi.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.repository.StudentRepository;
import com.springframework.studentrecordapi.web.mappers.StudentMapper;
import com.springframework.studentrecordapi.web.model.StudentBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private StudentBean student;

    private List<StudentBean> students = new LinkedList<StudentBean>();

    @Override
    public List<StudentBean> getStudents() {
        Iterator<Student> st = studentRepository.findAll().iterator();
        while (st.hasNext()) {
            student = studentMapper.studentToStudentBean(st.next());
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Map<String, String>> getStudentById(String studentId) {
        System.out.println(studentRepository.getAllSubjectCodeByStudentId(studentId));
        return studentRepository.getAllSubjectCodeByStudentId(studentId);
    }

    @Override
    public List<Map<String, String>> getStudentBySubjectCode(String subjectCode) {
        return studentRepository.getAllStudentIdBySubjectCode(subjectCode);
    }

    @Override
    public List<StudentBean> getStudents(int page) {
        List<Student> st = studentRepository.findAll(PageRequest.of(page, 10)).toList();
        for (Student eStudent : st) {
            student = studentMapper.studentToStudentBean(eStudent);
            students.add(student);
        }
        return students;
    }
}