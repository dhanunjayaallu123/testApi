package com.Student.studentapplication.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "local_JPA.Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Sname")
	private String name;
	
	

    @Column
    (name="Sage")
	private int age;
	
	@Column(name="Sbranch")
	private String Branch;
	
	private String lastname;
	
	
	
	
	
	
	
	
	
	
	

	public Student() {
		super();
	}	


	public Student(String name, int age, String branch, String lastname) {
		super();
		this.name = name;
		this.age = age;
		Branch = branch;
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	
	
	

}
