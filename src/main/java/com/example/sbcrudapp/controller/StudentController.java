package com.example.sbcrudapp.controller;

import com.example.sbcrudapp.dto.StudentDto;
import com.example.sbcrudapp.service.StudentService;
import com.example.sbcrudapp.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }
}
