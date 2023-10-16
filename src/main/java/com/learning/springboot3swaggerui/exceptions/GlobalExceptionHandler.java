package com.learning.springboot3swaggerui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // That is refactored from Runtime exception to Custom exception
    /*@ExceptionHandler(UserServiceException.class)
    public ProblemDetail handleUserServiceException(UserServiceException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("User service exception");
        problemDetail.setType(URI.create("http://localhost:8080/api/v1/error/not-found"));
        return problemDetail;
    }*/

    @ExceptionHandler(Exception.class)
    public ProblemDetail handle(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail(e.getMessage());
        problemDetail.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return problemDetail;
    }
}
