/**
 * 
 */
package com.jama.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jama.api.dao.CourseDAO;
import com.jama.api.dao.StudentDAO;

import com.jama.api.model.Course;
import com.jama.api.model.Student;

/**
 * @author ajara
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	EmailService emailService;
	
	
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		List<Student> lista =  studentDAO.findAll();		
		
		return lista;
	}

	@Override
	@Transactional
	public void save(Student student) {			
		studentDAO.save(student);	
		
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		
		Optional<Student> studentOpt = studentDAO.findById(theId);
		
		Student student= studentOpt.get();
		
		return student;
		
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		 
		studentDAO.deleteById(theId);
		
	}

	@Override
	@Transactional
	public List<Student> getStudentsByName(String name) {
		
		List<Student> lista =  studentDAO.getStudentsByLastName(name);
		
		return lista;
	}

	@Override
	@Transactional
	public void paymentStudent(int theId, String concept, double amount) {
	
	}
	//TODO implementar el pago
	/*@Override
	@Transactional
	public void paymentStudent(int theId, String concept, double amount) {
		
		//TODO se debe generar un codigo unico de pago o algo asi
		//TODO asi como esta, se debe de resetear el status de P a todos los alumnos cada inicio de mes. 
				//se debe de cambiar para que el status dependa de si existe o no un registro en payments del mes actual o tambien se puede
				// usar esto: org.springframework.scheduling.annotation.Scheduled; para hacer un cron que se ejecute cada primero de mes
		studentDAO.paymentStudent(theId, concept, amount);
		
		
		Student student = studentDAO.getStudent(theId);
		//send email
		//TODO parametrizar los datos del mail usando un properties, como debe usarse en spring
		//FALTA agregar info del detalle de pago
		emailService.sendMail(student.getEmail(), "Pago instituto de ingles", "Estimad@ "+student.getFirstName()
				+".\n Gracias por pagar la cantidad: "
				+ amount +", "
						+ "por el concepto de: "
						+concept
						+ ". \n Te esperamos en clase.");
		
	}*/

}
