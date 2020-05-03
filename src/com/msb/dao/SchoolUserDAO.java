package com.msb.dao;

import java.util.List;
import java.util.Map;

import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.SchoolUser;
import com.msb.model.UserLikeValidation;

public interface SchoolUserDAO {

	public SchoolUser validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveSchoolUser(SchoolUser other);

	public boolean activateRegisteredUser(String activationCode);

	public boolean updateUser(SchoolUser other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public UserLikeValidation checkStudentLike(
			UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public SchoolUser getStudentDetails(String username);

	public SchoolUser getStudentDetailsById(Integer id);

	public int getTopStudentsCount();

	public List<SchoolUser> getTopStudents();

	public List<CompetitionText> getUserTextEntries(String username, int limit);

	public List<MSTCompetition> getUserMSTEntries(String username, String type, int limit);
	
}
