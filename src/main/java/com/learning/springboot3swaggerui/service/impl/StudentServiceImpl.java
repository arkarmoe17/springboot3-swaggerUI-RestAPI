package com.learning.springboot3swaggerui.service.impl;

import com.learning.springboot3swaggerui.model.Student;
import com.learning.springboot3swaggerui.model.constants.Gender;
import com.learning.springboot3swaggerui.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final List<Student> students = new ArrayList<>(){
        {
            add(new Student(1L, "A","A@gmail.com",Gender.MALE,"English"));
            add(new Student(2L, "B","B@gmail.com",Gender.FEMALE,"English"));
            add(new Student(3L, "C","C@gmail.com",Gender.MALE,"English"));
            add(new Student(41L, "D","D@gmail.com",Gender.FEMALE,"English"));
        }
    };
    @Override
    public List<Student> findAllStudents() {
        return students;
    }
}
