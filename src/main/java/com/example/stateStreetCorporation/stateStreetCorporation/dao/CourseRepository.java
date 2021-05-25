package com.example.stateStreetCorporation.stateStreetCorporation.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stateStreetCorporation.stateStreetCorporation.models.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	public List<Course> findAllByName(String name);

}
