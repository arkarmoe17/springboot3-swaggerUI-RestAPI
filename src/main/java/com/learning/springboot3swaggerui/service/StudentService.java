package com.learning.springboot3swaggerui.service;

import com.learning.springboot3swaggerui.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    List<Student> findAllStudents();
}
