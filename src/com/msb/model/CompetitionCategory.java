package com.msb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "competition_category")
public class CompetitionCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CATEGORY_PK")
	@GeneratedValue
	private int category_pk;

	@Column(name = "CATEGORY_NAME")
	private String category_name;

	@Column(name = "CATEGORY_DESC")
	private String category_desc;

	@OneToMany(mappedBy = "competitionCategory")
	private List<Competition> competitions;

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public int getCategory_pk() {
		return category_pk;
	}

	public void setCategory_pk(int category_pk) {
		this.category_pk = category_pk;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_desc() {
		return category_desc;
	}

	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}

	@Override
	public String toString() {
		return category_name + ":" + category_desc;
	}

}
