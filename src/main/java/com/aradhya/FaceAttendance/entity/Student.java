package com.aradhya.FaceAttendance.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="students")
@Data
@Getter
@Setter



public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rollNumber;

    private String email;

    private String photoPath;





    


}

