package com.msb.service;

import java.util.List;
import java.util.Map;

import com.msb.model.SchoolUser;
import com.msb.constants.MsbConstants;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.UserLikeValidation;

public interface SchoolUserService {

	public SchoolUser validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveSchoolUser(SchoolUser other);

	public boolean activateRegisteredUser(String activationCode);

	public boolean changePassword(SchoolUser other);

	public boolean updateProfilePicture(SchoolUser other);

	public boolean updateUserDetails(SchoolUser other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public boolean isStudentLiked(UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public SchoolUser getStudentDetails(String username);

	public SchoolUser getStudentDetailsById(int id);

	public int getTopStudentsCount();

	public List<SchoolUser> getTopStudents();

	public List<CompetitionText> getUserRecentTextEntries(String username);

	public List<CompetitionText> getUserTextEntries(String username);

	public List<MSTCompetition> getUserRecentMSTEntries(String username, String type);

	public List<MSTCompetition> getUserMSTEntries(String username, String type);

}
