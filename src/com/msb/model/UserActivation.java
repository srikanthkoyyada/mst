package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "STUDENT_ACTIVATION")
@SecondaryTable(name = "STUDENT_ACTIVATION")
@org.hibernate.annotations.Table(appliesTo = "STUDENT_ACTIVATION", fetch = FetchMode.SELECT, optional = true)
public class UserActivation implements Serializable {

	private static final long serialVersionUID = 1L;

	private int student_id;
	private String activation_code; 

	
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	@Column(table = "STUDENT_ACTIVATION")
	public String getActivation_code() {
		return activation_code;
	}

	public void setActivation_code(String activation_code) {
		this.activation_code = activation_code;
	}

	/*
	 * @OneToOne
	 * 
	 * @PrimaryKeyJoinColumn public Other getUser() { return activeuser; }
	 * 
	 * public void setUser(Other activeuser) { this.activeuser = activeuser; }
	 */

	@Override
	public String toString() {
		return String.valueOf(student_id);
	}

}
