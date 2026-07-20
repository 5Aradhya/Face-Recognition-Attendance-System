package com.aradhya.FaceAttendance.controller;


import com.aradhya.FaceAttendance.dto.StudentDTO;
import com.aradhya.FaceAttendance.entity.Student;
import com.aradhya.FaceAttendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/welcome")
    @ResponseBody
    public String welcomPage(){
        return "Welcome to Face Attendence System";
    }


    @GetMapping("students/view")
    public String viewStudents (Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("students/add")
    public String showAddForm(Model model){
        model.addAttribute("student",new Student());
        return "add-student";
    }
    @PostMapping("students/add")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return"redirect:/students/view";
    }

    @GetMapping("students/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "update-student";
    }
    @PostMapping("students/update/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students/view";
    }

    @GetMapping("/api/students")
    @ResponseBody
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudentDTOs();
    }
    @GetMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students/view";
    }

}
