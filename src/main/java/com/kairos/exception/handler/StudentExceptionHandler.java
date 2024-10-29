package com.kairos.exception.handler;

import com.kairos.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.kairos")
public class StudentExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<String> handleStudentException(StudentException studentException) {
        return new ResponseEntity<>("please send proper student id.", HttpStatus.BAD_REQUEST);
    }
}
