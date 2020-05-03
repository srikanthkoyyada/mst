package com.msb.service;

import java.util.List;
import java.util.Map;

import com.msb.model.CollegeUser;
import com.msb.model.Other;
import com.msb.model.UserLikeValidation;

public interface CollegeUserService {

	public CollegeUser validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveCollegeUser(CollegeUser other);

	public boolean activateRegisteredUser(String activationCode);

	public boolean changePassword(CollegeUser other);

	public boolean updateProfilePicture(CollegeUser other);

	public boolean updateUserDetails(CollegeUser other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public boolean isStudentLiked(UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public CollegeUser getStudentDetails(String username);

	public CollegeUser getStudentDetailsById(int id);

	public int getTopStudentsCount();

	public List<CollegeUser> getTopStudents();

}
