package com.Student.studentapplication.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Student.studentapplication.entity.Student;
import com.Student.studentapplication.model.StudentName;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	

List<Student> findByName(String name);
List<Student> findByAgeBetween(BigDecimal start,BigDecimal end);
List<Student> findByNameLike(String name);
List<Student> findByNameContaining(String name);
List<Student> findByNameContainingIgnoreCase(String name);








 
	
	

}
