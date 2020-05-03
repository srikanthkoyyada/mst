package com.msb.dao;

import java.sql.SQLException;
import java.util.List;

import com.msb.bean.StudentCompetitionPoints;
import com.msb.model.Competition;
import com.msb.model.CompetitionText;
import com.msb.model.EntryComments;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.UploadATalent;

public interface CompetitionDAO {

	public List<Competition> getCompetitionsForSchool(int competionCategory);

	public List<Competition> getCompetitionsByCategory(int competionCategory, int userSegment);

	public Competition getCompetitionDetails(int compid);

	public Competition loadCompetitionDetails(int compid);

	public Integer saveTextCompetition(CompetitionText competitionText);

	public boolean updateCompetition(Competition competition);

	public Integer getUserTotalTextSubmissions(
			String username, String type);	

	public Integer getUserTotalMSTCometitionSubmissions(
			String username, String submission_type);

	public Integer saveMSTCompetitions(MSTCompetition pmdCompetition);

	public Integer getMSTCompetitionMaxID();

	public CompetitionText getTextCompetitionSubmission(Integer id);

	public MSTCompetition getMSTCompetitionSubmission(Integer id);

	public UploadATalent getUploadATalentSubmission(Integer id);

	public boolean updateTextSubmissionPoints(Integer id, int points);
	
	public boolean updateMSTSubmissionPoints(Integer id, int points);

	public boolean updateUATSubmissionPoints(Integer id, int points);

	public List<StudentCompetitionPoints> getStudentCompetitionPoints(
			String user_name);

	public int getNextOrPreviousTextId(int id, boolean next,
			boolean previous);
	
	public int getNextOrPreviousUatId(int id, boolean next,
			boolean previous);

	public boolean saveTextEntryVisit(int id) throws SQLException;
	
	public boolean saveEntryVisit(int id) throws SQLException;
	
	/* Others DAO */
	public Integer saveUploadATalent(UploadATalent uploadATalent);

	public Integer getUploadATalentMaxID();

	public Integer getStudentTotalUatSubmissionsCount(String username);
	
	public boolean saveUatEntryVisit(int id) throws SQLException;

	public int getNextOrPreviousEntryId(int id, String type, boolean next, boolean previous);

	public List<MSTCompetition> getAllMSTEntries(String type, int userCategory, int limit, int offset);

	public List<MSTCompetition> getAllMSTEntriesByClient(String type, String comp_by, int limit, int offset);

	public List<CompetitionText> getAllTextEntries(String type, int userCategory, int limit, int offset);

	public List<UploadATalent> getAllUATEntries(int userCategory, int limit, int offset);
	
	public List<CompetitionText> getAllTextEntriesByClient(String type, String comp_by, int limit, int offset);
	
	public Integer getStudentTotalTextSubmissionsOfACompetition(
			String username, int comp_id);

	public Integer getStudentTotalMSTSubmissionsOfACompetition(
			String username, int comp_id);
}
