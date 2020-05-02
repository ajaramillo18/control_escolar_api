/**
 * 
 */
package com.jama.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/students/{studentId}")
	 public Student getStudents(@PathVariable int studentId){
		 
		 Student student = service.getStudent(studentId);
		 
		 return student;
		 
	 }
	
	
	
	
	@GetMapping(value = "/students", params="last_name") //se usa params para distinguir de la URL sin parametros
	 public List<Student> getStudents(@RequestParam(name="last_name") String studentLastName){
		 
		 List<Student> studentList = service.getStudentsByName(studentLastName);
		 
		 return studentList;
		 
	 }
	
	@PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)	
	public Student saveStudent(@RequestBody Student student) {
		
		Student studentSaved = service.save(student);
		 
		 return studentSaved;		
		
	}
	
	@DeleteMapping("/students/{studentId}")	
	public String deleteStudent(@PathVariable int studentId) {
		
		service.deleteStudent(studentId);
		
		return "Estudiante con id: " + studentId + " ha sido borrado.";
	}
	
	@PutMapping("/students")	
	public Student updateStudent(@RequestBody Student student) {
		
		Student studentSaved = service.save(student);
		 
		 return studentSaved;		
		
	}
	
	// TODO falta agregar manejo de excepciones
	
	
	
	

}
