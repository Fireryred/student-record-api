package com.springframework.studentrecordapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @Id
    private String student_id;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ClassDetails> class_details;
}
