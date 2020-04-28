package com.jama.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jama.api.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

	//does this really works?
	
	
}
