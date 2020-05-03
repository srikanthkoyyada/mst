package com.msb.dao;

import java.util.List;

import com.msb.bean.StudentQuizPoints;
import com.msb.model.Quiz;
import com.msb.model.QuizGenre;
import com.msb.model.QuizPoints;
import com.msb.model.QuizScores;

public interface QuizDAO {

	public List<Quiz> getQuizzesBasedOnClient(String client, int genre,
			Integer offset, Integer maxResults, String user_segment);
	
	public List<Quiz> getAllQuizzesBasedOnClient(String client,
			Integer offset, Integer maxResults, String user_segment);
	
	public List<Quiz> getTeacherQuizzesBasedOnClient(String client,Integer offset, Integer maxResults, String category);
	
	public int getTeacherQuizzesCountBasedOnClient(String client, String user_category);

	public int getQuizzesCountBasedOnClient(String client, int genre,
			String user_segment);
	
	public int getAllQuizzesCountBasedOnClient(String client,
			String user_segment);

	public List<QuizGenre> getAllQuizGenres();

	public Quiz getQuiz(int id);

	public boolean isStudenTakentest(String id, String user_name);

	public boolean saveQuizScores(QuizScores quizScores);

	public boolean saveQuizPoints(QuizPoints quizPoints);

	public List<StudentQuizPoints> getStudentQuizPoints(String user_name);

	public Integer getNumberOfQuizParticipationsByStudent(String username);

	public Integer getStudentDayQuizCount(String username);

	public boolean updateStudentDayQuizCount(String username);

	public int getQuizzesCountBasedOnGenre(String client,
			List<QuizGenre> quizGenres, String user_segment);
	
}
