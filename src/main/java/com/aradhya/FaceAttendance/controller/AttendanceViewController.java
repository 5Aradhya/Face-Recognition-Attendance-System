package com.aradhya.FaceAttendance.controller;

import com.aradhya.FaceAttendance.dto.MarkAttendanceRequestDTO;
import com.aradhya.FaceAttendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AttendanceViewController {
    @Autowired
    private AttendanceService attendanceService;

    // Attendance list dikhane wala page
    @GetMapping("/attendance")
    public String showAttendanceList(Model model) {
        model.addAttribute("attendanceList", attendanceService.getAllAttendanceDTOs());
        return "attendance";
    }

    // Manual mark form dikhane wala page
    @GetMapping("/mark-attendance")
    public String showMarkForm(Model model) {
        model.addAttribute("attendance", new MarkAttendanceRequestDTO());
        return "mark-attendance";
    }

    // Form submit hone pe attendance save karna
    @PostMapping("/mark-attendance")
    public String markAttendance(@ModelAttribute MarkAttendanceRequestDTO request) {
        attendanceService.markAttendance(request);
        return "redirect:/attendance";
    }
}