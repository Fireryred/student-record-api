package com.springframework.studentrecordapi.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.web.model.StudentBean;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentBean studentToStudentBean(Student st);

    Student studentBeanToStudent(StudentBean st);
}
