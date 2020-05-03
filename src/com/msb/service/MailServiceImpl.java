package com.msb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.dao.MailDAO;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailDAO mailDAO;

	@Override
	public boolean sendMail(String subject, String Text, String recipient,boolean multipleRecipients,String mailTitle) {

		return mailDAO.sendMail(subject, Text, recipient,multipleRecipients,mailTitle);
	}

}
