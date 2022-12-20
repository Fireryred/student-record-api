package com.springframework.studentrecordapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Record API", version = "1.3", description = "Student Records	"))
public class StudentRecordApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordApiApplication.class, args);
	}

}
