package com.example.sbcrudapp.service;

import com.example.sbcrudapp.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public StudentDto getStudent(long id);
    public List<StudentDto> getAllStudents();
    public StudentDto deleteStudent(long id);
    public StudentDto saveStudent(StudentDto studentDto);
}
