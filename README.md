# Face Recognition Attendance System

A full-stack attendance system that uses real-time face recognition to automatically mark student attendance.

## Tech Stack

- Backend: Java, Spring Boot, Spring Security
- Face Recognition: Python, OpenCV, DeepFace
- Database: MySQL
- Authentication: JWT

## Features

- Student & Attendance CRUD
- Real-time face recognition via webcam
- Automatic attendance marking
- JWT authentication with role-based access (ADMIN/USER)

## How It Works

The Python script recognizes a face via webcam and sends the name to the Spring Boot backend, which marks attendance for the matching student in MySQL.

## Author

Built by Aradhya Uttam — B.Tech (Software Development) student.
