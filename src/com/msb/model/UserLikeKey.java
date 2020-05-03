package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;

public class UserLikeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME_OR_MAIL")
	private String username;

	@Column(name = "ENTRY_ID")
	private int entry_id;

	@Column(name = "COMP_TYPE")
	private String comp_type;
	
	public  UserLikeKey(){
		
	}
	
	
	public  UserLikeKey(String username,int entry_id,String comp_type) {
		this.username=username;
		this.entry_id=entry_id;
		this.comp_type=comp_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public String getComp_type() {
		return comp_type;
	}

	public void setComp_type(String comp_type) {
		this.comp_type = comp_type;
	}

}
