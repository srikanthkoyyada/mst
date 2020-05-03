package com.msb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.msb.model.Quiz;
import com.msb.model.QuizGenre;
import com.msb.model.QuizPoints;
import com.msb.model.QuizScores;
import com.msb.model.Other;
import com.msb.service.QuizService;
import com.msb.service.OtherService;
import com.msb.util.MsbUtil;

@Controller
public class OthersTestsController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private OtherService otherService;

	@RequestMapping(value = "/others/user/test-submission", method = RequestMethod.GET)
	public ModelAndView showTestSubmission(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/others/tests/submit-test");
		return modelAndView;
	}

	@RequestMapping(value = "/others/tests", method = RequestMethod.GET)
	public ModelAndView showTestsCategories() {
		ModelAndView modelAndView = new ModelAndView();
		List<QuizGenre> quizGenres = quizService.getAllQuizGenres();
		modelAndView.addObject("quizGenres", quizGenres);
		modelAndView.setViewName("/others/tests/test_categories");
		return modelAndView;
	}

	@RequestMapping(value = "/others/tests/{categoryid}/{offset}", method = RequestMethod.GET)
	public ModelAndView getCategoryTests(@PathVariable String client,
			@PathVariable int categoryid, @PathVariable int offset) {
		ModelAndView modelAndView = new ModelAndView();
		//List<Quiz> quizList = quizService.getQuizzesBasedOnGenre(categoryid, offset, 10);
		//int totalQuizCount = quizService.getQuizzesCount(categoryid);
		//modelAndView.addObject("quizList", quizList);
		modelAndView.addObject("offset", offset);
		modelAndView.addObject("categoryid", categoryid);
		//modelAndView.addObject("totalQuizCount", totalQuizCount);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("/others/tests/user_tests");
	
		return modelAndView;
	}

	@RequestMapping(value = "/others/user/taketest/{id}", method = RequestMethod.GET)
	public ModelAndView takeTest(@PathVariable int id, HttpSession session) {
		Other userData = (Other) session.getAttribute("Student");
		boolean isPremium = isStudentPremium(userData);
		ModelAndView modelAndView = new ModelAndView();
		int testsCount=quizService.getStudentDayQuizCount(userData.getUsername());
		System.out.println("testsCount"+testsCount);
		if (isPremium ||  testsCount< 3) {
			Quiz quiz = quizService.getQuiz(id);
			LinkedHashMap<String, List<String>> quizBuild = MsbUtil.buildQuiz(
					quiz.getQuestions(), quiz.getKeyset());

			/* check whether user taken the test or not */
			boolean isTestTaken = quizService.isStudenTakentest(quiz.getId(),
					userData.getUsername());

			/* check whether user segment and quiz category is same or not */
			
			modelAndView.addObject("isTestTaken", isTestTaken);
			modelAndView.addObject("quizBuild", quizBuild);
			modelAndView.addObject("quiz", quiz);
			modelAndView.setViewName("/others/tests/take-test");
		} else {
			modelAndView.setViewName("/others/tests/test-count-exceeded");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/others/user/submittest/{id}", method = RequestMethod.POST)
	public String submitTest(@PathVariable int id,
			@RequestParam Map<String, String> paramsMap,
			RedirectAttributes redirectAttributes, HttpSession session) {
		Other userData = (Other) session.getAttribute("Student");
		Quiz quiz = quizService.getQuiz(id);
		int totalQuestionsAttempted = 0;
		int correctAnswers = 0;
		StringBuffer studentAsnwersString = new StringBuffer();
		char[] answers = quiz.getResult().toCharArray();
		// System.out.println("answer string length"+quiz.getResult().length());
		for (int i = 0; i < answers.length; i++) {
			String answer;
			if ((answer = paramsMap.get("qno" + (i + 1))) != null) {
				totalQuestionsAttempted++;
				studentAsnwersString.append(answer);
				if (answer.equals(String.valueOf(answers[i]))) {
					correctAnswers++;
				}
			} else {
				studentAsnwersString.append("X");
			}
		}
		/*
		 * for (Entry<String, String> entry : paramsMap.entrySet()) {
		 * System.out.println(entry.getKey() + "::" + entry.getValue()); }
		 */
		/* To display on test submission jsp page */
		redirectAttributes.addFlashAttribute("correct", correctAnswers);
		redirectAttributes.addFlashAttribute("attempted",
				totalQuestionsAttempted);

		/*
		 * if all answers are correct 5 bonus points other wise 2 points for
		 * each question
		 */
		int studetnScore = (correctAnswers == quiz.getNoq()) ? ((correctAnswers * 2) + 5)
				: (correctAnswers * 2);

		/* Quiz Score */
		QuizScores quizScores = new QuizScores();
		quizScores.setQuiz_id(quiz.getId());
		quizScores.setUser_name(userData.getUsername());
		quizScores.setAnswers(studentAsnwersString.toString());
		quizScores.setMax_score(quiz.getNoq() * 2);
		quizScores.setScore(studetnScore);

		if (paramsMap.get("isTestTaken").equals("yes")) {
			quizService.saveQuizScores(quizScores);
		} else if (paramsMap.get("isUserCategory").equals("no")) {
			quizService.saveQuizScores(quizScores);
		} else if (paramsMap.get("isTestTaken").equals("no")
				&& paramsMap.get("isUserCategory").equals("yes")) {
			String totalTime = "00:"
					+ String.format("%02d", quiz.getDuration()) + ":00";

			/* Quiz Points */
			QuizPoints quizPoints = new QuizPoints();
			quizPoints.setQuiz_id(quiz.getId());
			quizPoints.setSubmission_date(MsbUtil.getCurrentDate());
			quizPoints.setAnswers(studentAsnwersString.toString());
			quizPoints.setPoints(studetnScore);
			quizPoints.setUser_name(userData.getUsername());
			quizPoints.setCompleted_time(MsbUtil.getSqlTimeDiff(totalTime,
					paramsMap.get("completedTime")));
			quizService.saveQuizScores(quizScores);
			quizService.saveQuizPoints(quizPoints);
			userData.setPoints(userData.getPoints()+studetnScore);
			otherService.updateUserDetails(userData);
		}
		
		//if(!isStudentPremium(userData)){
			quizService.updateStudentDayQuizCount(userData.getUsername());
			System.out.println("Update Day test count");
		//}
		return "redirect:/others/user/test-submission";

	}

	private boolean isStudentPremium(Other userData) {
		
		System.out.println("No Premium");
		return false;
	}

}
