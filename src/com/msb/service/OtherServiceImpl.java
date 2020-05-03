package com.msb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.constants.MsbConstants;
import com.msb.dao.OtherDAO;
import com.msb.model.AskAnExpert;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.PaymentDetails;
import com.msb.model.UserLikeValidation;
import com.msb.util.MsbUtil;

@Service
public class OtherServiceImpl implements OtherService {

	@Autowired
	OtherDAO userDao;

	@Override
	public Other validateUser(String username, String password) {
		return userDao.validateUser(username, password);
	}

	@Override
	public Map<String, String> getStudentPassword(String userNameOrMail) {

		return userDao.getStudentPassword(userNameOrMail);
	}

	@Override
	public boolean saveOther(Other other) {

		return userDao.saveOther(other);
	}
	
	@Override
	public boolean saveStudent(Other user) {

		return userDao.saveStudent(user);
	}

	@Override
	public boolean activateRegisteredUser(String activationCode) {

		return userDao.activateRegisteredUser(activationCode);
	}

	@Override
	public boolean isUserExist(String username) {

		return userDao.isUserExist(username);
	}

	@Override
	public boolean changePassword(Other other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean updateProfilePicture(Other other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean updateUserDetails(Other other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean saveStudentLike(UserLikeValidation userLikeValidation) {

		return userDao.saveStudentLike(userLikeValidation);
	}

	@Override
	public boolean isStudentLiked(UserLikeValidation userLikeValidation) {
		UserLikeValidation userLikeValidation1 = userDao
				.checkStudentLike(userLikeValidation);
		if (userLikeValidation1 != null) {
			return MsbUtil.isDateIsToday(String.valueOf(userLikeValidation1
					.getLikeDate()));

		} else
			return false;

	}

	@Override
	public boolean updateUserPoints(String username, int points) {
		return userDao.updateUserPoints(username, points);
	}

	@Override
	public Other getStudentDetails(String username) {

		return userDao.getStudentDetails(username);
	}

	@Override
	public Other getStudentDetailsById(int id) {
		return userDao.getStudentDetailsById(id);
	}
	
	public int getTopStudentsCount() {		
		return userDao.getTopStudentsCount();
	}
	
	@Override
	public List<Other> getTopStudents() {
		return userDao.getTopStudents();
	}
}
