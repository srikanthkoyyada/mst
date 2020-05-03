package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TESTS_COUNT")
public class StudentTestsCount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "NUMBER_OF_TESTS")
	private int no_of_tests;

	@Column(name = "DATE_OF_TESTS")
	private java.util.Date submit_date;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getNo_of_tests() {
		return no_of_tests;
	}

	public void setNo_of_tests(int no_of_tests) {
		this.no_of_tests = no_of_tests;
	}

	public java.util.Date getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(java.util.Date submit_date) {
		this.submit_date = submit_date;
	}

}
