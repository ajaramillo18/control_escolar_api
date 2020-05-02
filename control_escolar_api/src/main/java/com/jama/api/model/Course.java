/**
 * 
 */
package com.jama.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@NamedQueries({
	@NamedQuery(name = "course.getCourses", query = "from Course order by name"),
	@NamedQuery(name = "course.getCoursesByName", query = "from Course where name = ?1 order by name")

})



/**
 * @author ajara
 *
 */
@Data
@Entity
@Table (name = "course")
@EqualsAndHashCode(exclude="students") //manytomany stackoverflowerror
@ToString(exclude="students") //manytomany stackoverflowerror
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "course_id")
	private int id;
	
	@Column (name = "name")
	@NotEmpty(message="*Dato Requerido") 	
	private String name;
		
	@Column (name = "status")
	private String status;
	
	//@Column (name = "teacher_id") 
	//int tutorId;
	@Column (name = "teacher_name")
	@NotEmpty(message="*Dato Requerido") 
	@Pattern(regexp="[a-zA-Z]*", message="*Solo letras")
	private String teacher;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.MERGE})
	
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)	
	@JsonBackReference //added to avoid infinite recursion caused by manyToMany when jackson makes the parsing to JSON	
	private Set<Student> students;

}
