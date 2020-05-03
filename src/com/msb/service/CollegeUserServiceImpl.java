package com.msb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.dao.CollegeUserDAO;
import com.msb.model.CollegeUser;
import com.msb.model.UserLikeValidation;
import com.msb.util.MsbUtil;

@Service
public class CollegeUserServiceImpl implements CollegeUserService {

	@Autowired
	CollegeUserDAO userDao;

	@Override
	public CollegeUser validateUser(String username, String password) {
		return userDao.validateUser(username, password);
	}

	@Override
	public Map<String, String> getStudentPassword(String userNameOrMail) {

		return userDao.getStudentPassword(userNameOrMail);
	}

	@Override
	public boolean saveCollegeUser(CollegeUser other) {

		return userDao.saveCollegeUser(other);
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
	public boolean changePassword(CollegeUser other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean updateProfilePicture(CollegeUser other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean updateUserDetails(CollegeUser other) {
		return userDao.updateUser(other);
	}

	@Override
	public boolean updateUserPoints(String username, int points) {
		return userDao.updateUserPoints(username, points);
	}

	@Override
	public CollegeUser getStudentDetails(String username) {

		return userDao.getStudentDetails(username);
	}

	@Override
	public CollegeUser getStudentDetailsById(int id) {
		return userDao.getStudentDetailsById(id);
	}
	
	public int getTopStudentsCount() {		
		return userDao.getTopStudentsCount();
	}
	
	@Override
	public List<CollegeUser> getTopStudents() {
		return userDao.getTopStudents();
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

}
