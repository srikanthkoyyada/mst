package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ_SCORES")
public class QuizScores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBMITID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int submitid;

	@Column(name = "QUIZID")
	private String quiz_id;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "SCORE")
	private int score;

	@Column(name = "MAX_SCORE")
	private int max_score;

	@Column(name = "ANL_FLG")
	private int anl_flg;

	@Column(name = "ANSWERS")
	private String answers;
	
	public QuizScores(){
		anl_flg=1;
	}

	public int getSubmitid() {
		return submitid;
	}

	public void setSubmitid(int submitid) {
		this.submitid = submitid;
	}

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMax_score() {
		return max_score;
	}

	public void setMax_score(int max_score) {
		this.max_score = max_score;
	}

	public int getAnl_flg() {
		return anl_flg;
	}

	public void setAnl_flg(int anl_flg) {
		this.anl_flg = anl_flg;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

}
