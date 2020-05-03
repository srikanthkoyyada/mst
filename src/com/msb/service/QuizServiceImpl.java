package com.msb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msb.bean.StudentQuizPoints;
import com.msb.dao.QuizDAO;
import com.msb.model.Quiz;
import com.msb.model.QuizGenre;
import com.msb.model.QuizPoints;
import com.msb.model.QuizScores;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDAO quizDAO;

	@Override
	public List<Quiz> getQuizzesBasedOnClient(String client, int genre,
			Integer offset, Integer maxResults, String user_segment) {

		return quizDAO.getQuizzesBasedOnClient(client, genre, offset,
				maxResults, user_segment);
	}
	
	@Override
	public List<Quiz> getAllQuizzesBasedOnClient(String client,
			Integer offset, Integer maxResults, String user_segment) {

		return quizDAO.getAllQuizzesBasedOnClient(client, offset,
				maxResults, user_segment);
	}
	// All quizzes

	@Override
	public List<QuizGenre> getAllQuizGenres() {

		return quizDAO.getAllQuizGenres();
	}

	@Override
	public int getQuizzesCountBasedOnClient(String client, int genre,
			String user_segment) {

		return quizDAO
				.getQuizzesCountBasedOnClient(client, genre, user_segment);
	}
	
	@Override
	public int getAllQuizzesCountBasedOnClient(String client,
			String user_segment) {

		return quizDAO
				.getAllQuizzesCountBasedOnClient(client, user_segment);
	}

	@Override
	public Quiz getQuiz(int id) {

		return quizDAO.getQuiz(id);
	}

	@Override
	public boolean isStudenTakentest(String id, String user_name) {

		return quizDAO.isStudenTakentest(id, user_name);
	}

	@Override
	public boolean saveQuizScores(QuizScores quizScores) {

		return quizDAO.saveQuizScores(quizScores);
	}

	@Override
	public boolean saveQuizPoints(QuizPoints quizPoints) {

		return quizDAO.saveQuizPoints(quizPoints);
	}

	@Override
	public List<StudentQuizPoints> getStudentQuizPoints(String user_name) {

		return quizDAO.getStudentQuizPoints(user_name);
	}

	@Override
	public Integer getNumberOfQuizParticipationsByStudent(String username) {

		return quizDAO.getNumberOfQuizParticipationsByStudent(username);
	}

	@Override
	public Integer getStudentDayQuizCount(String username) {

		return quizDAO.getStudentDayQuizCount(username);
	}

	@Override
	public boolean updateStudentDayQuizCount(String username) {
		
		return quizDAO.updateStudentDayQuizCount(username);
	}

	@Override
	public List<Quiz> getTeacherQuizzesBasedOnClient(String client,
			Integer offset, Integer maxResults, String category) {
		
		return quizDAO.getTeacherQuizzesBasedOnClient(client, offset, maxResults, category);
	}

	@Override
	public int getTeacherQuizzesCountBasedOnClient(String client,
			String user_category) {
		
		return quizDAO.getTeacherQuizzesCountBasedOnClient(client, user_category);
	}

	@Override
	public int getQuizzesCountBasedOnGenre(String client,
			List<QuizGenre> quizGenres, String user_segment) {
		// TODO Auto-generated method stub
		return quizDAO
				.getQuizzesCountBasedOnGenre(client, quizGenres, user_segment);
	}

}
