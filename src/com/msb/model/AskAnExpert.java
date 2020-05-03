package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.msb.util.MsbUtil;

@Entity
@Table(name = "ASKANEXPERT")
public class AskAnExpert implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "A_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int a_id;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "FULL_NAME")
	private String full_name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "SUBMIT_DATE")
	private java.util.Date submit_date;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "SCHOOL")
	private String school;
	
	public AskAnExpert(){
		submit_date=MsbUtil.getCurrentDate();
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public java.util.Date getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(java.util.Date submit_date) {
		this.submit_date = submit_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
