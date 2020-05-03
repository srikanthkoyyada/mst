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
@Table(name = "UPLOAD_A_TALENT")
public class UploadATalent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ENTRY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "ENTRY_DESCRIPTION")
	private String description;

	@Column(name = "SUBMISSION_DATE")
	private java.util.Date submit_date;

	@Column(name = "POINTS")
	private int points;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "ENTRY_FILE_NAME")
	private String entry_file_name;
	
	@Column(name = "CONTENT")
	private String content;

	@Column(name = "ENTRY_TYPE")
	private String entry_type;
	
	@Column(name = "AREA")
	private String area;
	
	@Column(name = "VISITS")
	private int visits;
	
	@Column(name = "COMP_ID")
	private int comp_id;
	
	@Column(name = "USER_STANDARD")
	private int user_standard;
	
	@Column(name = "USER_CATEGORY")
	private int user_category;
	
	@ManyToOne(targetEntity = Other.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_NAME", referencedColumnName = "USER_NAME", insertable = false, updatable = false)
	private Other other;
	
	public Other getUser() {
		return other;
	}

	public void setUser(Other other) {
		this.other = other;
	}

	public UploadATalent() {
		setSubmit_date(MsbUtil.getCurrentDate());
		setPoints(20);
		setStatus(1);
	}

	@Override
	public String toString() {
		return description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getEntry_file_name() {
		return entry_file_name;
	}

	public void setEntry_file_name(String entry_file_name) {
		this.entry_file_name = entry_file_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
