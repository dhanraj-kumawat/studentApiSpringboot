package com.example.sbcrudapp.service.impl;

import com.example.sbcrudapp.dao.StudentDao;
import com.example.sbcrudapp.dto.StudentDto;
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
        if(optionalStudent.isEmpty()){
            return new StudentDto();
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(optionalStudent.get().getId());
        studentDto.setName(optionalStudent.get().getName());
        studentDto.setEmail(optionalStudent.get().getEmail());
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDao.findAll();

        List<StudentDto> studentDtos = new ArrayList<>();

        for(Student student : students){
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setEmail(student.getEmail());
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }

    @Override
    public StudentDto deleteStudent(long id) {
        Optional<Student> optionalStudent = studentDao.findById(id);
        StudentDto studentDto = new StudentDto();
        if(optionalStudent.isEmpty())
            return studentDto;

        studentDto.setId(optionalStudent.get().getId());
        studentDto.setName(optionalStudent.get().getName());
        studentDto.setName(optionalStudent.get().getEmail());
        return studentDto;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        // to save in db we need to convert studentDto(pojo) to student(entity)
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        Student dbStudent=studentDao.save(student);
        // for response, we need to convert entity to dto/pojo
        StudentDto studentDto1 = new StudentDto();
        studentDto1.setId(dbStudent.getId());
        studentDto1.setName(dbStudent.getName());
        studentDto1.setEmail(dbStudent.getEmail());
        return studentDto1;
    }
}
