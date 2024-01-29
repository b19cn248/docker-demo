package com.ptit.dockerdemo.service.impl;

import com.ptit.dockerdemo.entity.Student;
import com.ptit.dockerdemo.repository.StudentRepository;
import com.ptit.dockerdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repository;

  @Override
  public Student create(Student student) {
    return repository.save(student);
  }

  @Override
  public List<Student> findAll() {
    return repository.findAll();
  }
}
