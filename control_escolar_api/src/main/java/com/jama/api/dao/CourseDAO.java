package com.jama.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jama.api.model.Course;


public interface CourseDAO extends JpaRepository<Course, Integer> {

	//does this really works?
	
	
}
