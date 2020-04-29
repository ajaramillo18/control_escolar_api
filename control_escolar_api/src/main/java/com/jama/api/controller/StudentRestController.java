/**
 * 
 */
package com.jama.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jama.api.model.Student;
import com.jama.api.service.StudentService;

/**
 * @author ajara
 *
 */
@RestController
public class StudentRestController {

	@Autowired
	StudentService service;
	 
	@GetMapping("/students")
	 public List<Student> getStudents(){
		 
		 List<Student> studentList = service.getStudents();
		 
		 return studentList;
		 
	 }
	
	
	

}
