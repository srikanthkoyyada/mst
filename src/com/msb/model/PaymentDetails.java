package com.msb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.msb.util.MsbUtil;

@Entity
@Table(name = "PREMIUM_PAYMENT_DETAILS")
public class PaymentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "PAYMENT_ID")
	private String payment_id;

	@Column(name = "PAYMENT_STATUS")
	private String payment_status;

	@Column(name = "AMOUNT_PAID")
	private int amount;

	@Column(name = "PAYMENT_DATE")
	private java.util.Date payment_date;
	

	@Column(name = "USER_MAIL")
	private String mail;
	
	

	public PaymentDetails() {
		payment_date = MsbUtil.getCurrentDate();
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public java.util.Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(java.util.Date payment_date) {
		this.payment_date = payment_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
