package com.springframework.studentrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.studentrecordapi.domain.ClassDetails;

public interface ClassDetailsRepository extends JpaRepository<ClassDetails, String> {

}
