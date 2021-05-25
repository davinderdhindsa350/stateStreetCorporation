package com.example.stateStreetCorporation.stateStreetCorporation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stateStreetCorporation.stateStreetCorporation.models.Course;
import com.example.stateStreetCorporation.stateStreetCorporation.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	
	public List<Student> findAllByOrderByName();

	public List<Student> findAllByCourse(List<Course> list);
	@Query("select * from STUDENT where id in (select distinct student_id from Student_Course SC inner join Course c on c.id=SC.course_id and c.name=?1)")
	public List<Student> getAllStudentsHaveNoCourse(String name);
}
