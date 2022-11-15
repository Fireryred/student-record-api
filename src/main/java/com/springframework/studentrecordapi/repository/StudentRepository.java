package com.springframework.studentrecordapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springframework.studentrecordapi.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
        // inner join to remove real(every records is the same) duplicates
        // group by to remove any duplicate in subject code/student id
        // just add another where if you wanted to add a limitation to the date
        @Query(value = "SELECT student.student_id AS id FROM student " +
                        "INNER JOIN class_details ON class_details.student_id = student.student_id " +
                        "WHERE subject_code = ?1 " +
                        "GROUP BY id", nativeQuery = true)
        List<Map<String, String>> getAllStudentIdBySubjectCode(String subjectCode);

        @Query(value = "SELECT class_details.subject_code, class_details.subject_desc FROM student " +
                        "INNER JOIN class_details ON class_details.student_id = student.student_id " +
                        "WHERE student.student_id = ?1 " +
                        "GROUP BY class_details.subject_code ", nativeQuery = true)
        List<Map<String, String>> getAllSubjectCodeByStudentId(String studentId);
}