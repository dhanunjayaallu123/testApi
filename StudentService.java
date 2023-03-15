package com.Student.studentapplication.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Student.studentapplication.entity.Student;
import com.Student.studentapplication.exception.ResourceNotFoundException;

import com.Student.studentapplication.repository.StudentRepository;
import com.Student.studentapplication.model.StudentFullName;
import com.Student.studentapplication.model.StudentName;
import com.zaxxer.hikari.util.FastList;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sRepository;
	
	public List<Student> getAllStudents() {
		return this.sRepository.findAll();
		
	}
	public List<Student> saveStudents(@RequestBody List<Student> student){
		return (List<Student>) sRepository.saveAll(student);
	
	}
	public Student getByid(@RequestParam ("id") long id) {
		return sRepository.findById(id).get();
		
	}
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
		return new ResponseEntity<List<Student>>(sRepository.findByName(name),HttpStatus.OK) ;
		
	}	
	public ResponseEntity<List<Student>> getStudentByAge(@RequestParam BigDecimal start,@RequestParam BigDecimal end){
		return new ResponseEntity<List<Student>>(sRepository.findByAgeBetween(start, end),HttpStatus.OK);
		
	}
	public ResponseEntity<List<Student>> getStudentByLike(@RequestParam String name){
		return new ResponseEntity<List<Student>>(sRepository.findByNameLike("%"+name+"%"),HttpStatus.OK);
		
	}
	public ResponseEntity<List<Student>> getStudentByContaining(@RequestParam String name){
		return new ResponseEntity<List<Student>>(sRepository.findByNameContaining(name),HttpStatus.OK);
		
	}
	public ResponseEntity<List<Student>> getByNameIgnore(@RequestParam String name){
		return new ResponseEntity<List<Student>>(sRepository.findByNameContainingIgnoreCase(name),HttpStatus.OK);
		
	}
	public List<Student> getAll(@RequestParam String Column){
		return sRepository.findAll(Sort.by(Direction.ASC,Column)) ;
		
	}
	public ResponseEntity<Student> updateStudents(@PathVariable Long id,@RequestBody Student studentDetails){
		Student student=sRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student not exists with id:"+id));
		
		
		student.setName(studentDetails.getName());
		student.setAge(studentDetails.getAge());
		student.setBranch(studentDetails.getBranch());
		
		
		Student updatedStudents=sRepository.save(student);
		
		
		return ResponseEntity.ok(updatedStudents) ;
		
	}
	public List<StudentName> getNames(){
		List<Student> students=sRepository.findAll();
		List<StudentName> studentnames=new ArrayList<>();
		List<StudentName> slas=new ArrayList<>();
		
		students.forEach(student->{
			StudentName studentname=new StudentName();
			studentname.setName( student.getName());
		   studentnames.add(studentname);
			
		});
		students.forEach(student->{
			StudentName sla=new StudentName();
			sla.setName(student.getLastname());
			slas.add(sla);
			
			
			
		});
		
		return studentnames;
	}
	public List<StudentFullName> getStudentFullNames(){
		
		List<Student> students=sRepository.findAll();
		List<StudentFullName> fullNames = new ArrayList<>();
		
		students.forEach(student->{
			StudentFullName fullName = new StudentFullName();
			fullName.setFullName( student.getName() + " " + student.getLastname());
			fullNames.add(fullName);
			
		});

		return fullNames;
		
}
}
