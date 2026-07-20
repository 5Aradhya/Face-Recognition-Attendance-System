package com.aradhya.FaceAttendance.dto;

import lombok.Data;

@Data
public class AttendanceDTO {

    private Long id;
    private String studentName;
    private String date;
    private String time;
}