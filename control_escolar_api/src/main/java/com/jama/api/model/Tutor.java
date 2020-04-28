/**
 * 
 */
package com.jama.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author ajara
 *
 */
@Data
@Entity
public class Tutor {
	
	@Id
	@Column (name = "tutor_id")
	private int tutorId;
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Column (name = "email")
	private String email;

}
