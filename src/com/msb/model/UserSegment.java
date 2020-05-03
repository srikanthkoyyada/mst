package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_segment")
public class UserSegment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEGMENT_PK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int segment_pk;

	@Column(name = "SEGMENT_NAME")
	private String segment_name;

	@Column(name = "SEGMENT_DESC")
	private String segment_desc;

	

	public int getSegment_pk() {
		return segment_pk;
	}

	public void setSegment_pk(int segment_pk) {
		this.segment_pk = segment_pk;
	}

	public String getSegment_name() {
		return segment_name;
	}

	public void setSegment_name(String segment_name) {
		this.segment_name = segment_name;
	}

	public String getSegment_desc() {
		return segment_desc;
	}

	public void setSegment_desc(String segment_desc) {
		this.segment_desc = segment_desc;
	}

	@Override
	public String toString() {
		return segment_name;
	}

}
