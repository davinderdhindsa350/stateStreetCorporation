package com.example.stateStreetCorporation.stateStreetCorporation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stateStreetCorporation.stateStreetCorporation.dao.CourseRepository;
import com.example.stateStreetCorporation.stateStreetCorporation.models.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course addCourse(Course course){
		
		 return courseRepository.save(course);
	}
	
	public List<Course> findeCourseName(String name){
		
		 return courseRepository.findAllByName(name);
	}
	
}
