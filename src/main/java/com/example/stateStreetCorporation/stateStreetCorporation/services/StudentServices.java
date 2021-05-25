package com.example.stateStreetCorporation.stateStreetCorporation.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stateStreetCorporation.stateStreetCorporation.dao.StudentRepository;
import com.example.stateStreetCorporation.stateStreetCorporation.models.Course;
import com.example.stateStreetCorporation.stateStreetCorporation.models.Student;


@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseService courseService;
	
	public Student addStudent(Student student){
		
		 return studentRepository.save(student);
	}
	
	@Transactional(rollbackOn  = { SQLException.class })
	public String delete(Long id){
		
		 studentRepository.deleteById(id);
		 Optional<Student> list=studentRepository.findById(id);
		 if(list.isEmpty())
			 return "Deleted Successfully";
		 else
			 return "Error While deleting";
	}
	public List<Student> getAllStudent(){
		return (List<Student>)studentRepository.findAll();
	}
	public List<Student> getAllStudentBySortByName(){
		return studentRepository.findAllByOrderByName();
	}
	public List<Student> getAllStudentByCouseName(String name) {
		// TODO Auto-generated method stub
		List<Course> list=courseService.findeCourseName(name);
		return studentRepository.findAllByCourse(list);
	}
	public List<Student> getAllStudentsHaveNoCourse(String Name) {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudentsHaveNoCourse(Name);
	}
	
	
	
}
