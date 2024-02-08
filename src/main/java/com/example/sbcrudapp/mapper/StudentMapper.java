package com.example.sbcrudapp.mapper;

import com.example.sbcrudapp.dto.StudentDto;
import com.example.sbcrudapp.model.Student;

public class StudentMapper {
    public static StudentDto toDto(Student s) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(s.getId());
        studentDto.setName(s.getName());
        studentDto.setEmail(s.getEmail());
        return studentDto;
    }

    public static Student toEntity(StudentDto sDto) {
        Student student = new Student();
        student.setId(sDto.getId());
        student.setEmail(sDto.getEmail());
        student.setName(sDto.getName());
        return student;
    }
}
