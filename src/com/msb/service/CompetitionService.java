package com.msb.service;

import java.util.List;

import com.msb.model.Competition;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.UploadATalent;
import com.msb.model.Other;

public interface CompetitionService {

	public List<Competition> getCompetitionsForSchool(int competionCategory);
	
	public List<Competition> getCompetitionsByCategory(int competionCategory, int userSegment);

	public Competition getCompetitionDetails(int compid);

	public Competition loadCompetitionDetails(int compid);

	public Integer saveTextCompetition(CompetitionText competitionText);

	public boolean updateCompetitionVisits(Competition competition);

	public boolean updateCompetitionTotalEntries(Competition competition);

	public Integer getUserTotalTextSubmissions(
			String username, String type);

	public Integer saveMSTCompetition(MSTCompetition pmd);

	public Integer getMstMaxID();

	public Integer getUserTotalSubmissions(
			String username, String submission_type);
	
	public CompetitionText getTextCompetitionSubmission(Integer id);
	
	public MSTCompetition getMSTCompetitionSubmission(Integer id);
	
	public UploadATalent getUploadATalentSubmission(Integer id);
	
	public boolean updateTextSubmissionPoints(Integer id,int points);
	
	public int getNextOrPreviousTextId(int id, boolean next,
			boolean previous);

	public int getNextOrPreviousEntryId(int id, String submission_type, boolean next, boolean previous);
	
	public int getNextOrPreviousUatId(int id, boolean next,
			boolean previous);

	public boolean saveTextEntryVisit(Integer id);
	
	public boolean saveEntryVisit(Integer id);

	public Other getStudentDetails(String user_name);
	
	/* others services */
	public Integer saveUploadATalent(UploadATalent  uploadATalent);
	 
	public Integer getUploadATalentMaxID();
	
	public Integer getStudentTotalUatSubmissionsCount(String username);
	
	public boolean saveUatEntryVisit(Integer id);
	
	public List<MSTCompetition> getAllMSTEntries(String type, int userCategory,
			int limit, int offset);

	public List<MSTCompetition> getAllMSTEntriesByClient(String type, String comp_by,
			int limit, int offset);
	
	public List<UploadATalent> getAllUATEntries(int userCategory, int limit, int offset);

	public List<CompetitionText> getAllTextEntries(String type, int userCategory, int limit, int offset);
	
	public List<CompetitionText> getAllTextEntriesByClient(String type, String comp_by, int limit, int offset);

	public boolean updateMSTSubmissionPoints(Integer id, int points);

	public boolean updateUATSubmissionPoints(Integer id, int points);
	
	public Integer getStudentTotalTextSubmissionsOfACompetition(
			String username, int comp_id);

	public Integer getStudentTotalMSTSubmissionsOfACompetition(
			String username, int comp_id);
	
}
