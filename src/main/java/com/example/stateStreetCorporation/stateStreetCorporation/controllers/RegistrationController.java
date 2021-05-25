package com.example.stateStreetCorporation.stateStreetCorporation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.stateStreetCorporation.stateStreetCorporation.models.Student;
import com.example.stateStreetCorporation.stateStreetCorporation.services.CourseService;
import com.example.stateStreetCorporation.stateStreetCorporation.services.StudentServices;

@RestController
public class RegistrationController {

	@Autowired
	StudentServices studentServices;
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addNewStudent")
	public ResponseEntity<?> addNewStudent(@RequestBody Student student) throws Exception {
		return new ResponseEntity<>(studentServices.addStudent(student),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/addNewStudent")
	public ResponseEntity<?> deleteStudent(@RequestParam Long studentId) throws Exception {
		
		return new ResponseEntity<>(studentServices.delete(studentId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents() throws Exception {
		return new ResponseEntity<>(studentServices.getAllStudent(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllStudentsSortedByName")
	public ResponseEntity<?> getAllStudentsSortedByName() throws Exception {
		return new ResponseEntity<>(studentServices.getAllStudentBySortByName(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllStudentsByCourseName")
	public ResponseEntity<?> getAllStudentsByCourseName(@RequestParam String name) throws Exception {
		return new ResponseEntity<>(studentServices.getAllStudentByCouseName(name),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllStudentsNotRegisteredForCourse")
	public ResponseEntity<?> getAllStudentsHaveNoCourse(@RequestParam String name) throws Exception {

		return new ResponseEntity<>(studentServices.getAllStudentsHaveNoCourse(name),HttpStatus.FOUND);
	}
	
	
	

}
