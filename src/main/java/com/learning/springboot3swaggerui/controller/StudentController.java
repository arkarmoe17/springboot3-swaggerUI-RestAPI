package com.learning.springboot3swaggerui.controller;

import com.learning.springboot3swaggerui.model.Student;
import com.learning.springboot3swaggerui.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@Tag(name = "Student", description = "Student API")
public class StudentController {
    private final StudentService studentService;

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
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
