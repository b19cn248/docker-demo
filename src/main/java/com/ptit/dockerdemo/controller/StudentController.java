package com.ptit.dockerdemo.controller;

import com.ptit.dockerdemo.entity.Student;
import com.ptit.dockerdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

  private final StudentService service;

  @PostMapping
  public ResponseEntity<Student> create(@RequestBody Student student) {
    return ResponseEntity.ok(service.create(student));
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
