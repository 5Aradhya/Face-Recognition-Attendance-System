package com.aradhya.FaceAttendance.service;

import com.aradhya.FaceAttendance.entity.Student;
import com.aradhya.FaceAttendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aradhya.FaceAttendance.dto.StudentDTO;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found with id"+id));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setRollNumber(updatedStudent.getRollNumber());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPhotoPath(updatedStudent.getPhotoPath());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public StudentDTO convertToDTO(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setRollNumber(student.getRollNumber());
        dto.setEmail(student.getEmail());
        dto.setPhotoPath(student.getPhotoPath());
        return dto;
    }

    public List<StudentDTO> getAllStudentDTOs(){
        return getAllStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}