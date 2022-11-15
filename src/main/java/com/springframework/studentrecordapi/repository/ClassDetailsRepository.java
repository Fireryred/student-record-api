package com.springframework.studentrecordapi.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springframework.studentrecordapi.domain.ClassDetails;

public interface ClassDetailsRepository extends JpaRepository<ClassDetails, String> {
    @Query(value = "SELECT * FROM class_details WHERE student_id = ?1", nativeQuery = true)
    ArrayList<ClassDetails> getAllClassDetailsFromStudentId(String studentId);
}
