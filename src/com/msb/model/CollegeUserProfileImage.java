package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "COLLEGEUSER_IMAGE")
@SecondaryTable(name = "COLLEGEUSER_IMAGE")
@org.hibernate.annotations.Table(appliesTo = "COLLEGEUSER_IMAGE", fetch = FetchMode.SELECT, optional = true)
public class CollegeUserProfileImage implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private byte[] image;

	// private Other user;

	/*
	 * @Id
	 * 
	 * @Column(name = "id", unique = true, nullable = false)
	 * 
	 * @GeneratedValue(generator = "gen")
	 * 
	 * @GenericGenerator(name = "gen", strategy = "foreign", parameters =
	 * 
	 * @Parameter(name = "property", value = "user"))
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(table = "COLLEGEUSER_IMAGE")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	/*
	 * @OneToOne
	 * 
	 * @PrimaryKeyJoinColumn public Other getUser() { return user; }
	 * 
	 * public void setUser(Other user) { this.user = user; }
	 */
	@Override
	public String toString() {
		return "UserImage";
	}

}
