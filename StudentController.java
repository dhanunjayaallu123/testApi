package com.Student.studentapplication.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Student.studentapplication.entity.Student;
import com.Student.studentapplication.exception.ResourceNotFoundException;
import com.Student.studentapplication.repository.StudentRepository;
import com.Student.studentapplication.model.StudentFullName;
import com.Student.studentapplication.model.StudentName;
import com.Student.studentapplication.service.StudentService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private StudentService studentS;
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return this.studentS.getAllStudents();

}
	
	@PostMapping("/saveStudents")
	public List<Student> createStudent(@RequestBody List<Student>
	student) {
		return  this.studentS.saveStudents(student);
	}
	@GetMapping("/getStudentByName")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
		return this.studentS.getStudentByName(name);
		
	}	
	@GetMapping("/getStudentById")
	public Student getNameByid(@RequestParam ("id") long id) {
		return this.studentS.getByid(id);
		
	}
	@GetMapping("/getStudentsBetweenAges")
	public ResponseEntity<List<Student>> getStudentByAge(@RequestParam BigDecimal start,@RequestParam BigDecimal end){
		return this.studentS.getStudentByAge(start, end);
		
	}
	@GetMapping("/getStudentsByWord")
	public ResponseEntity<List<Student>> getStudentByLike(@RequestParam String word){
		return this.studentS.getStudentByLike(word);
		
	}
	@GetMapping("/getStudentByNameContain")
	public ResponseEntity<List<Student>> getStudentByContaining(@RequestParam String na){
		return this.studentS.getStudentByContaining(na);
		
	}
	@GetMapping("/getStudentNamesCaseIgnore")
	public ResponseEntity<List<Student>> getByNameIgnore(@RequestParam String nam){
		return this.studentS.getByNameIgnore(nam);
		
	}
	@GetMapping("/sortedStudents")
	public List<Student> getAll(@RequestParam String Col){
		return  this.studentS.getAll(Col);
		
	}
	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable Long id,@RequestBody Student studentDetails){
		
		return this.studentS.updateStudents(id, studentDetails) ;
		
	}
	@GetMapping("/getStudentNames")
	public List<StudentName> getStudentNames(){
		return this.studentS.getNames();
	
	
	}
	@GetMapping("/getStudentFullNames")
	public List<StudentFullName> getStudentFullNames(){
		

		return this.studentS.getStudentFullNames();
		

}
}

	

