package com.ptit.dockerdemo.service;

import com.ptit.dockerdemo.entity.Student;

import java.util.List;

public interface StudentService {

  Student create(Student student);

  List<Student> findAll();
}
