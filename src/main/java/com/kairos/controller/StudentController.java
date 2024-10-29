package com.kairos.controller;

import com.kairos.entity.Address;
import com.kairos.entity.Student;
import com.kairos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("getStudents")
    public ResponseEntity<List<Student>> getStudents() {

        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }
    @GetMapping("getAddress")
    public ResponseEntity<List<Address>> getAddress() {

        return new ResponseEntity<>(service.getAddress(), HttpStatus.OK);
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.verify(student), HttpStatus.OK);
    }

}
