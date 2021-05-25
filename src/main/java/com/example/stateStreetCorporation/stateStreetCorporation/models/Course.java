package com.example.stateStreetCorporation.stateStreetCorporation.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
	private List<Student> student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
}
