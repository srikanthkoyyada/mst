package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.msb.util.MsbUtil;

@Entity
@Table(name = "TEXT_COMPETITION")
public class CompetitionText implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ENTRY_TYPE")
	private String entry_type;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "SUMMARY")
	private String summary;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "SUBMIT_DATE")
	private java.util.Date submit_date;

	@Column(name = "POINTS")
	private int points;

	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "VISITS")
	private int visits;
	
	@Column(name = "PRIVACY")
	private int privacy;
	
	@Column(name = "COMP_ID")
	private int comp_id;
	
	@Column(name = "COMP_CATEGORY")
	private int category;
	
	@Column(name = "REPORTS")
	private int reports;
	
	@Column(name = "USER_STANDARD")
	private int user_standard;
	
	@Column(name = "USER_CATEGORY")
	private int user_category;
	
	@Column(name = "COMP_BY")
	private String comp_by;
	
	@ManyToOne(targetEntity = CompetitionCategory.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "COMP_CATEGORY", referencedColumnName = "CATEGORY_PK", insertable = false, updatable = false)
	private CompetitionCategory competitionCategory;

	public CompetitionCategory getCompetitionCategory() {
		return competitionCategory;
	}

	public void setCompetitionCategory(CompetitionCategory competitionCategory) {
		this.competitionCategory = competitionCategory;
	}

	@ManyToOne(targetEntity = Competition.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID", insertable = false, updatable = false)
	private Competition competition;

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	@ManyToOne(targetEntity = Other.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false)
	private Other other;
	
	public Other getUser() {
		return other;
	}

	public void setUser(Other other) {
		this.other = other;
	}

	public CompetitionText(){
		setSubmit_date(MsbUtil.getCurrentDate());
		setPoints(20);
		setStatus(1);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(java.util.Date submit_date) {
		this.submit_date = submit_date;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	public int getReports() {
		return reports;
	}

	public void setReports(int reports) {
		this.reports = reports;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	public int getUser_standard() {
		return user_standard;
	}

	public void setUser_standard(int user_standard) {
		this.user_standard = user_standard;
	}

	public int getUser_category() {
		return user_category;
	}

	public void setUser_category(int user_category) {
		this.user_category = user_category;
	}
	
	public String getComp_by() {
		return comp_by;
	}

	public void setComp_by(String comp_by) {
		this.comp_by = comp_by;
	}

}
