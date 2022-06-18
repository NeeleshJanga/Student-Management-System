package com.springboot.project.repository;

import com.springboot.project.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student, Long> {

}
