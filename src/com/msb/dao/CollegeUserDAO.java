package com.msb.dao;

import java.util.List;
import java.util.Map;

import com.msb.model.CollegeUser;
import com.msb.model.UserLikeValidation;

public interface CollegeUserDAO {

	public CollegeUser validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveCollegeUser(CollegeUser other);

	public boolean activateRegisteredUser(String activationCode);

	public boolean updateUser(CollegeUser other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public UserLikeValidation checkStudentLike(
			UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public CollegeUser getStudentDetails(String username);

	public CollegeUser getStudentDetailsById(Integer id);

	public int getTopStudentsCount();

	public List<CollegeUser> getTopStudents();
	
}
