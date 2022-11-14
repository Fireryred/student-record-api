package com.springframework.studentrecordapi.web.mappers;

import org.mapstruct.Mapper;

import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.web.model.StudentBean;

@Mapper
public interface StudentMapper {
    StudentBean studentToStudentBean(Student st);

    Student studentBeanToStudent(StudentBean st);
}
