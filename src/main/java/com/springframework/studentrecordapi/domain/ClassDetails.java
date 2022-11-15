package com.springframework.studentrecordapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "class_details")
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ClassDetails {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    private String subject_code;
    private String subject_desc;
    private String week_start_date;
    private String week_end_date;
    private String exact_class_date;
    private String day_of_week;
    private String room_number;
    private String room;
    private String gps_coordinates;
    private String start_time;
    private String end_time;
    private String campus_code;
    private boolean hasStandardRoomDescription;
    private int duration;
    private String duration_code;
    private boolean isHoliday;
}