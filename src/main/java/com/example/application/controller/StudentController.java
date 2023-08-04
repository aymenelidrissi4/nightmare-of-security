package com.example.application.controller;

import com.example.application.exception.StudentNotFound;
import com.example.application.model.Student;
import com.example.application.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping("/add")
    public String addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/find/{id}")
    public Student findStudent(@PathVariable Long id) throws StudentNotFound {
        return studentService.findStudent(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@Valid @RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
