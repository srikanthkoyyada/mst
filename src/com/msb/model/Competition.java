package com.msb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import com.msb.util.MsbUtil;

@Entity
@Table(name = "COMPETITIONS")
public class Competition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comp_id;

	@Column(name = "USER_SEGMENT")
	private int user_category;

	@Column(name = "COMPETITION_CATEGORY")
	private int comp_category;
	
	@Past(groups = { Competition.class })
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date start_date;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date end_date;

	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "TOPIC")
	private String topic;

	@Column(name = "POSTED_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date posted_date;
	
	public Competition() {
		posted_date = MsbUtil.getCurrentDate();
	}

	@Column(name = "COMPETITION_BY")
	private String comp_by;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Transient
	private boolean is_competition_started;
	
	@Transient
	private boolean is_competition_closed;

	@ManyToOne(targetEntity = CompetitionCategory.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPETITION_CATEGORY", referencedColumnName = "CATEGORY_PK", insertable = false, updatable = false)
	private CompetitionCategory competitionCategory;

	public CompetitionCategory getCompetitionCategory() {
		return competitionCategory;
	}

	public void setCompetitionCategory(CompetitionCategory competitionCategory) {
		this.competitionCategory = competitionCategory;
	}

	@ManyToOne(targetEntity = UserSegment.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_SEGMENT", referencedColumnName = "SEGMENT_PK", insertable = false, updatable = false)
	private UserSegment userSegment;

	public UserSegment getUserSegment() {
		return userSegment;
	}

	public void setUserSegment(UserSegment userSegment) {
		this.userSegment = userSegment;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	
	public java.util.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.util.Date start_date) {
		this.start_date = start_date;
	}

	public java.util.Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public java.util.Date getPosted_date() {
		return posted_date;
	}

	public void setPosted_date(java.util.Date posted_date) {
		this.posted_date = posted_date;
	}

	public String getComp_by() {
		return comp_by;
	}

	public void setComp_by(String comp_by) {
		this.comp_by = comp_by;
	}
	
	public boolean isIs_competition_started() {
		return is_competition_closed;
	}

	public void setIs_competition_started(boolean is_competition_started) {
		this.is_competition_started = is_competition_started;
	}

	public boolean isIs_competition_closed() {
		return is_competition_closed;
	}

	public void setIs_competition_closed(boolean is_competition_closed) {
		this.is_competition_closed = is_competition_closed;
	}

	public int getUser_category() {
		return user_category;
	}

	public void setUser_category(int user_category) {
		this.user_category = user_category;
	}

	public int getComp_category() {
		return comp_category;
	}

	public void setComp_category(int comp_category) {
		this.comp_category = comp_category;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
