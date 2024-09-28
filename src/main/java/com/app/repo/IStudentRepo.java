package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {

}
