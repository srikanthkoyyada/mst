package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZ_GENRES")
public class QuizGenre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GENRE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int genre_id;

	@Column(name = "GENRE")
	private String genre_name;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz_geners") private
	 * List<Quiz> quiList;
	 * 
	 * public List<Quiz> getQuiList() { return quiList; }
	 * 
	 * public void setQuiList(List<Quiz> quiList) { this.quiList = quiList; }
	 */

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

}
