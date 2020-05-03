package com.msb.service;

import java.util.List;
import java.util.Map;

import com.msb.model.Other;
import com.msb.model.UserLikeValidation;

public interface OtherService {

	public Other validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveOther(Other other);
	
	public boolean saveStudent(Other user);

	public boolean activateRegisteredUser(String activationCode);

	public boolean changePassword(Other other);

	public boolean updateProfilePicture(Other other);

	public boolean updateUserDetails(Other other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public boolean isStudentLiked(UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public Other getStudentDetails(String username);

	public Other getStudentDetailsById(int id);

	public int getTopStudentsCount();

	public List<Other> getTopStudents();

}
