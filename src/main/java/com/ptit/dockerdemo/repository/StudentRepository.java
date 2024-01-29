package com.ptit.dockerdemo.repository;

import com.ptit.dockerdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
