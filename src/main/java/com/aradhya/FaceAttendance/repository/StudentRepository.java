package com.aradhya.FaceAttendance.repository;

import com.aradhya.FaceAttendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);
}