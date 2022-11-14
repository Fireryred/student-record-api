package com.springframework.studentrecordapi.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.persistence.EntityManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.studentrecordapi.domain.ClassDetails;
import com.springframework.studentrecordapi.domain.Student;
import com.springframework.studentrecordapi.repository.ClassDetailsRepository;
import com.springframework.studentrecordapi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentLoader implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final ClassDetailsRepository classDetailsRepository;

    @Override
    public void run(String... args) throws Exception, InterruptedException, ExecutionException {
        loadStudent();
    }

    private void loadStudent() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/output.json");
        try {
            if (studentRepository.findAll().size() == 0) {
                List<Student> students = mapper.readValue(inputStream, typeReference);
                for (Student student : students) {
                    for (ClassDetails dt : student.getClass_details()) {
                        dt.setStudent(student);
                        classDetailsRepository.save(dt);
                    }
                }
                studentRepository.saveAll(students);
            }
        } catch (IOException e) {
            System.out.println("Unable to load student: " + e.getMessage());
        }
    }

}
