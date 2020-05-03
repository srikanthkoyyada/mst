package com.msb.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENTRY_COMMENTS")
public class EntryComments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;

	@Column(name = "USER_ID")
	private int user_id;

	@Column(name = "REPORTED")
	private int reported;

	@Column(name = "ENTRY_ID")
	private int entry_id;

	@Column(name = "VOTES")
	private int votes;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "ENTRY_TYPE")
	private String entry_type;

	@Column(name = "COMMENT_TEXT")
	private String comment_text;

	@Column(name = "COMMENT_DATE")
	private Timestamp comment_date;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "id", updatable = false,insertable=false)
	private Other other;

	public Other getUser() {
		return other;
	}

	public void setUser(Other other) {
		this.other = other;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(String entry_type) {
		this.entry_type = entry_type;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}

}
