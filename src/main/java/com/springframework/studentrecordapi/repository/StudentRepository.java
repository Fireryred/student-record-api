package com.springframework.studentrecordapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springframework.studentrecordapi.domain.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, String> {

}
