package com.learning.springboot3swaggerui.controller;

import com.learning.springboot3swaggerui.model.Student;
import com.learning.springboot3swaggerui.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
@Tag(name = "Student", description = "Student API")
public class StudentController {
    private final StudentService studentService;

    // CREATE STUDENT
    @Operation(
            description = "Endpoint for creating the student",
            summary = "Creating student API",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student payload) {
        Student student = studentService.createStudent(payload);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // GET ALL STUDENTS
    @Operation(
            description = "Endpoint for getting all students",
            summary = "Fetching all students API",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized/Invalid Token",
                            responseCode = "403",
                            content = @Content(
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }
}
