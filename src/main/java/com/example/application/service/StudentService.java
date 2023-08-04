package com.example.application.service;

import com.example.application.exception.StudentNotFound;
import com.example.application.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    String addStudent(Student student);
    Student findStudent(Long id) throws StudentNotFound;
    String updateStudent(Student student);
    String deleteStudent(Long id);
}
