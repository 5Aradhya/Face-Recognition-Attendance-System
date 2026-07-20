package com.aradhya.FaceAttendance.service;

import com.aradhya.FaceAttendance.dto.AttendanceDTO;
import com.aradhya.FaceAttendance.dto.MarkAttendanceRequestDTO;
import com.aradhya.FaceAttendance.entity.Attendance;
import com.aradhya.FaceAttendance.entity.Student;
import com.aradhya.FaceAttendance.repository.AttendanceRepository;
import com.aradhya.FaceAttendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Attendance markAttendance(MarkAttendanceRequestDTO request){
        Student student = studentRepository.findByName(request.getStudentName());

        if (student == null){
            throw new RuntimeException("Student not found with name: " + request.getStudentName());
        }

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(request.getDate());
        attendance.setTime(request.getTime());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public AttendanceDTO convertToDTO(Attendance attendance){
        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(attendance.getId());
        dto.setStudentName(attendance.getStudent().getName());
        dto.setDate(attendance.getDate());
        dto.setTime(attendance.getTime());
        return dto;
    }

    public List<AttendanceDTO> getAllAttendanceDTOs(){
        return getAllAttendance()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}