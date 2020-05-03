package com.msb.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ_TABLE")
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "QUIZ_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quiz_id;

	@Column(name = "ID")
	private String id;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "NAME")
	private String name;

	@Column(name = "RESULT")
	private String result;

	@Column(name = "QUESTIONS")
	private String questions;

	@Column(name = "KEYSET")
	private String keyset;

	@Column(name = "NOQ")
	private int noq;

	@Column(name = "GENRE")
	private int genre;

	@Column(name = "POSTED_DATE")
	private Timestamp posted_date;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DURATION")
	private int duration;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "CLIENT")
	private String client;

	@Column(name = "PARAGRAPH_TEXT")
	private String paragraph_text;

	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "genre",insertable=false, nullable = false, updatable
	 * = false) private QuizGenre quizGenre;
	 * 
	 * public QuizGenre getQuizGenre() { return quizGenre; }
	 * 
	 * public void setQuizGenre(QuizGenre quizGenre) { this.quizGenre =
	 * quizGenre; }
	 */

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getKeyset() {
		return keyset;
	}

	public void setKeyset(String keyset) {
		this.keyset = keyset;
	}

	public int getNoq() {
		return noq;
	}

	public void setNoq(int noq) {
		this.noq = noq;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public Timestamp getPosted_date() {
		return posted_date;
	}

	public void setPosted_date(Timestamp posted_date) {
		this.posted_date = posted_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getParagraph_text() {
		return paragraph_text;
	}

	public void setParagraph_text(String paragraph_text) {
		this.paragraph_text = paragraph_text;
	}

}
