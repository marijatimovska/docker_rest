package com.iwec.restDocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iwec.restDocker.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
