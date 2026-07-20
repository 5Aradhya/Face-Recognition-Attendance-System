package com.aradhya.FaceAttendance.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String rollNumber;
    private String email;
    private String photoPath;
}