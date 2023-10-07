package com.learning.springboot3swaggerui.repository;

import com.learning.springboot3swaggerui.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
