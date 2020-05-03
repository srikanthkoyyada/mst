package com.msb.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ_POINTS")
public class QuizPoints implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "QUIZID")
	private String quiz_id;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "POINTS")
	private int points;

	@Column(name = "SUBMISSION_DATE")
	private Date submission_date;

	@Column(name = "COMPLETED_TIME")
	private Time completed_time;

	@Column(name = "ANSWERS")
	private String answers;

	public String getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(String quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

	public Time getCompleted_time() {
		return completed_time;
	}

	public void setCompleted_time(Time completed_time) {
		this.completed_time = completed_time;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}
	
	

}
