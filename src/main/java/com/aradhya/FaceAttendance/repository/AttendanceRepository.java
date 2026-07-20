package com.aradhya.FaceAttendance.repository;

import com.aradhya.FaceAttendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
