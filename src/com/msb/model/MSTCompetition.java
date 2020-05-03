package com.msb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "MST_SUBMISSION")
public class MSTCompetition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBMISSION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "ENTRY_SUMMARY")
	private String entry_summary;

	@Column(name = "SUBMIT_DATE")
	private java.util.Date submit_date;

	@Column(name = "POINTS")
	private int points;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "SUBMISSION_FILE_NAME")
	private String submission_file_name;

	@Column(name = "SUBMISSION_TYPE")
	private String submission_type;
	
	@Column(name = "VISITS")
	private int visits;
	
	@Column(name = "COMP_ID")
	private int comp_id;
	
	@Column(name = "COMP_CATEGORY")
	private int category;
	
	@Column(name = "USER_STANDARD")
	private int user_standard;
	
	@Column(name = "USER_CATEGORY")
	private int user_category;
	
	@Column(name = "REPORTS")
	private int reports;
	
	@Column(name = "COMP_BY")
	private String comp_by;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Competition.class, fetch = FetchType.LAZY)
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

	public MSTCompetition() {
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getEntry_summary() {
		return entry_summary;
	}

	public void setEntry_summary(String entry_summary) {
		this.entry_summary = entry_summary;
	}

	public String getSubmission_file_name() {
		return submission_file_name;
	}

	public void setSubmission_file_name(String submission_file_name) {
		this.submission_file_name = submission_file_name;
	}

	public String getSubmission_type() {
		return submission_type;
	}

	public void setSubmission_type(String submission_type) {
		this.submission_type = submission_type;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
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
