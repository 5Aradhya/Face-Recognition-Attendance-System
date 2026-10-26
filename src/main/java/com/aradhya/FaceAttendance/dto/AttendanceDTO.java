package com.aradhya.FaceAttendance.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AttendanceDTO {

    private Long id;
    private String studentName;
    private LocalDate date;
    private LocalTime time;
}
