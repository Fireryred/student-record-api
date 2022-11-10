package com.springframework.studentrecordapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDetails {
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
