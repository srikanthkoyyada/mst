package com.msb.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.constants.MsbConstants;
import com.msb.dao.CompetitionDAO;
import com.msb.dao.OtherDAO;
import com.msb.model.Competition;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.UploadATalent;
import com.msb.model.Other;
import com.msb.util.MsbUtil;

@Service
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	CompetitionDAO competitiondao;
	
	@Autowired
	OtherDAO userDao;

	
	@Override
	public List<Competition> getCompetitionsForSchool(int competionCategory) {

		List<Competition> competitions = competitiondao
				.getCompetitionsForSchool(competionCategory);
		Iterator<Competition> iterator = competitions.iterator();
		while (iterator.hasNext()) {
			Competition competition = (Competition) iterator.next();
			//competition.setIs_competition_started(MsbUtil
					//.isCompetitionStarted(competition.getStart_date()
							//.toString()));
			competition
					.setIs_competition_closed(MsbUtil
							.isCompetitionClosed(competition.getEnd_date()
									.toString()));

		}
		return competitions;

	}
	
	@Override
	public List<Competition> getCompetitionsByCategory(int competionCategory, int userSegment) {
		
		List<Competition> competitions = competitiondao
				.getCompetitionsByCategory(competionCategory, userSegment);
		Iterator<Competition> iterator = competitions.iterator();
		while (iterator.hasNext()) {
			Competition competition = (Competition) iterator.next();
			//competition.setIs_competition_started(MsbUtil
					//.isCompetitionStarted(competition.getStart_date()
							//.toString()));
			competition
					.setIs_competition_closed(MsbUtil
							.isCompetitionClosed(competition.getEnd_date()
									.toString()));

		}
		return competitions;

	}

	@Override
	public Competition getCompetitionDetails(int compid) {
		Competition competition = competitiondao.getCompetitionDetails(compid);
		competition.setIs_competition_closed(MsbUtil
				.isCompetitionClosed(competition.getEnd_date().toString()));
		return competition;
	}

	@Override
	public Competition loadCompetitionDetails(int compid) {

		return competitiondao.loadCompetitionDetails(compid);
	}

	@Override
	public Integer saveTextCompetition(CompetitionText competitionText) {

		return competitiondao.saveTextCompetition(competitionText);

	}

	@Override
	public boolean updateCompetitionVisits(Competition competition) {

		return competitiondao.updateCompetition(competition);
	}

	@Override
	public boolean updateCompetitionTotalEntries(Competition competition) {

		return competitiondao.updateCompetition(competition);
	}

	@Override
	public Integer getUserTotalTextSubmissions(
			String username, String type) {

		return competitiondao.getUserTotalTextSubmissions(
				username, type);
	}

	@Override
	public Integer getUserTotalSubmissions(
			String username, String submission_type) {

		return competitiondao
				.getUserTotalMSTCometitionSubmissions(
						username, submission_type);
	}

	@Override
	public Integer getMstMaxID() {

		return competitiondao.getMSTCompetitionMaxID();
	}

	@Override
	public CompetitionText getTextCompetitionSubmission(Integer id) {

		return competitiondao.getTextCompetitionSubmission(id);
	}

	@Override
	public MSTCompetition getMSTCompetitionSubmission(Integer id) {
		return competitiondao.getMSTCompetitionSubmission(id);
	}

	@Override
	public UploadATalent getUploadATalentSubmission(Integer id) {
		return competitiondao.getUploadATalentSubmission(id);
	}

	@Override
	public boolean updateTextSubmissionPoints(Integer id, int points) {

		return competitiondao.updateTextSubmissionPoints(id, points);
	}
	
	@Override
	public boolean updateMSTSubmissionPoints(Integer id, int points) {
		return competitiondao.updateMSTSubmissionPoints(id, points);
	}

	@Override
	public boolean updateUATSubmissionPoints(Integer id, int points) {
		return competitiondao.updateUATSubmissionPoints(id, points);
	}
	
	@Override
	public int getNextOrPreviousTextId(int id,
			boolean next, boolean previous) {
		
		return competitiondao.getNextOrPreviousTextId(id, next, previous);
	}
	
	@Override
	public int getNextOrPreviousEntryId(int id, String submission_type, boolean next, boolean previous) {
		// TODO Auto-generated method stub
		return competitiondao.getNextOrPreviousEntryId(id, submission_type, next, previous);
	}
	
	@Override
	public int getNextOrPreviousUatId(int id,
			boolean next, boolean previous) {
		
		return competitiondao.getNextOrPreviousUatId(id, next, previous);
	}
	
	@Override
	public boolean saveTextEntryVisit(Integer id) {

		try {
			return competitiondao.saveTextEntryVisit(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean saveEntryVisit(Integer id) {		
			try {
				return competitiondao.saveEntryVisit(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public Other getStudentDetails(String user_name) {
		return userDao.getStudentDetails(user_name);
	}
	
	/* Others services */
	@Override
	public Integer saveUploadATalent(UploadATalent uploadATalent) {
		return competitiondao.saveUploadATalent(uploadATalent);
	}

	@Override
	public Integer getUploadATalentMaxID() {
		return competitiondao.getUploadATalentMaxID();
	}

	@Override
	public Integer getStudentTotalUatSubmissionsCount(String username) {
		return competitiondao.getStudentTotalUatSubmissionsCount(username);
	}
	
	@Override
	public boolean saveUatEntryVisit(Integer id) {		
			try {
				return competitiondao.saveUatEntryVisit(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public Integer saveMSTCompetition(MSTCompetition pmd) {
		// TODO Auto-generated method stub
		return competitiondao.saveMSTCompetitions(pmd);
	}

	@Override
	public List<CompetitionText> getAllTextEntries(String type, int userCategory,
			int limit, int offset) {

		return competitiondao.getAllTextEntries(type, userCategory, limit, offset);
	}
	
	@Override
	public List<CompetitionText> getAllTextEntriesByClient(String type, String comp_by,
			int limit, int offset) {

		return competitiondao.getAllTextEntriesByClient(type, comp_by, limit, offset);
	}
	
	@Override
	public List<MSTCompetition> getAllMSTEntries(String type, int userCategory,
			int limit, int offset) {

		return competitiondao.getAllMSTEntries(type, userCategory, limit, offset);
	}
	
	@Override
	public List<MSTCompetition> getAllMSTEntriesByClient(String type, String comp_by,
			int limit, int offset) {

		return competitiondao.getAllMSTEntriesByClient(type, comp_by, limit, offset);
	}
	
	@Override
	public List<UploadATalent> getAllUATEntries(int userCategory, int limit, int offset) {

		return competitiondao.getAllUATEntries(userCategory, limit, offset);
	}

	@Override
	public Integer getStudentTotalTextSubmissionsOfACompetition(
			String username, int comp_id) {

		return competitiondao.getStudentTotalTextSubmissionsOfACompetition(
				username, comp_id);
	}

	@Override
	public Integer getStudentTotalMSTSubmissionsOfACompetition(
			String username, int comp_id) {

		return competitiondao.getStudentTotalMSTSubmissionsOfACompetition(
				username, comp_id);
	}
	
}
