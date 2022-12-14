package com.springframework.studentrecordapi.web.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentBean implements Serializable {
    private String student_id;
    private ArrayList<ClassDetailsBean> class_details;
}
