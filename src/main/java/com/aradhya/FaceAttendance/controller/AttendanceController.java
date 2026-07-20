package com.aradhya.FaceAttendance.controller;

import com.aradhya.FaceAttendance.dto.AttendanceDTO;
import com.aradhya.FaceAttendance.dto.MarkAttendanceRequestDTO;
import com.aradhya.FaceAttendance.entity.Attendance;
import com.aradhya.FaceAttendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody MarkAttendanceRequestDTO request) {
        return attendanceService.markAttendance(request);
    }

    @GetMapping("/all")
    public List<AttendanceDTO> getAllAttendance() {
        return attendanceService.getAllAttendanceDTOs();
    }
}