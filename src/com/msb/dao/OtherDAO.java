package com.msb.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.msb.model.AskAnExpert;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.PaymentDetails;
import com.msb.model.UserLikeValidation;

public interface OtherDAO {

	public Other validateUser(String username, String password);

	public boolean isUserExist(String username);

	public Map<String, String> getStudentPassword(String userNameOrMail);

	public boolean saveOther(Other other);

	public boolean activateRegisteredUser(String activationCode);

	public boolean updateUser(Other other);

	public boolean saveStudentLike(UserLikeValidation userLikeValidation);

	public UserLikeValidation checkStudentLike(
			UserLikeValidation userLikeValidation);

	public boolean updateUserPoints(String username, int points);

	public boolean saveAskAnExpert(AskAnExpert askAnExpert);

	public List<CompetitionText> getUserTextEntries(String username,
			int textCategory, int limit);

	public List<MSTCompetition> getUserPMDDEntries(String username,
			String entryCategory, int limit);

	public Other getStudentDetails(String username);

	public boolean savePaymentDetails(PaymentDetails paymentDetails);

	public boolean updateUserPointsForDebates(int id, int points);

	public Other getStudentDetailsById(Integer id);

	public int getTopStudentsCount();

	public List<Other> getTopStudents();

	public Integer getStudentMaxID();

	public int getTotalUsersCount() throws ParseException;

	public boolean saveStudent(Other user);
	
}
