package com.jama.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jama.api.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

	List<Student> getStudentsByLastName(String lastName);

	//does this really works?
	
	
}
