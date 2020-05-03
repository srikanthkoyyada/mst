package com.msb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.msb.util.MsbUtil;

@IdClass(UserLikeKey.class)
@Entity
@Table(name = "USER_LIKE_VALIDATION")
public class UserLikeValidation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERNAME_OR_MAIL")
	private String username;

	@Id
	@Column(name = "ENTRY_ID")
	private int entry_id;

	@Id
	@Column(name = "COMP_TYPE")
	private String comp_type;

	@Column(name = "DATE_OF_LIKE")
	private Date likeDate;
	
	@Transient
	private String entry_username;
	
	//int oldLikes;
	
	public UserLikeValidation(){
		setLikeDate(MsbUtil.getCurrentDate());
	}

		
	public String getEntry_username() {
		return entry_username;
	}

	public void setEntry_username(String entry_username) {
		this.entry_username = entry_username;
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

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}


	//public int getOldLikes() {
		//return oldLikes;
	//}


	//public void setOldLikes(int oldLikes) {
		//this.oldLikes = oldLikes;
	//}

	

}
