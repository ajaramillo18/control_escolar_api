/**
 * 
 */
package com.jama.api.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jama.api.model.Student;

/**
 * @author ajara
 *
 */

public interface StudentService {

	public List<Student> getStudents();

	public void save(Student student);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

	public List<Student> getStudentsByName(String name);

	public void paymentStudent(int theId, String concept, double d);
}
