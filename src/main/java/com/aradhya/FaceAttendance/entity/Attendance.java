package com.aradhya.FaceAttendance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attendance")
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String date;

    private String time;
}