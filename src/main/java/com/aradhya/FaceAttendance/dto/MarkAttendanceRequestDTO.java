package com.aradhya.FaceAttendance.dto;

import lombok.Data;

@Data
public class MarkAttendanceRequestDTO {
    private String studentName;
    private String date;
    private String time;
}