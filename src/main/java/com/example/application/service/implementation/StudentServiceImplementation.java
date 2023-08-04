package com.example.application.service.implementation;

import com.example.application.exception.StudentNotFound;
import com.example.application.model.Student;
import com.example.application.repository.StudentRepository;
import com.example.application.service.StudentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImplementation implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "student with id " + student.getId() + " added successfully";
    }

    @Override
    public Student findStudent(Long id) throws StudentNotFound {
        return Optional.of(studentRepository.findById(id)).get().orElseThrow(() -> new StudentNotFound("student with id " + id + " not found"));
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "student with id " + student.getId() + " updated successfully";
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "student with id " + id + " deleted successfully";
    }
}
