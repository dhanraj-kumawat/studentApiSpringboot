package com.example.sbcrudapp.service.impl;

import com.example.sbcrudapp.dao.StudentDao;
import com.example.sbcrudapp.dto.StudentDto;
import com.example.sbcrudapp.mapper.StudentMapper;
import com.example.sbcrudapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements com.example.sbcrudapp.service.StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentDto getStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        if (optionalStudent.isEmpty()) {
            return new StudentDto();
        }

        return StudentMapper.toDto(optionalStudent.get());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDao.findAll();

        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            studentDtos.add(StudentMapper.toDto(student));
        }
        return studentDtos;
    }

    @Override
    public StudentDto deleteStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDto studentDto = new StudentDto();
        if (optionalStudent.isEmpty())
            return studentDto;

        return StudentMapper.toDto(optionalStudent.get());
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // to save in db we need to convert studentDto(pojo) to student(entity)
        Optional<Student> optionalStudent = studentDao.findById(studentDto.getId());
        if (!optionalStudent.isEmpty())
            return studentDto;
        Student student = StudentMapper.toEntity(studentDto);
        Student dbStudent = studentDao.save(student);
        // for response, we need to convert entity to dto/pojo
        return StudentMapper.toDto(dbStudent);
    }
}
