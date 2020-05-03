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
import com.msb.model.SchoolUser;
import com.msb.service.QuizService;
import com.msb.service.SchoolUserService;
import com.msb.util.MsbUtil;

@Controller
public class TestsController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private SchoolUserService userService;

	@RequestMapping(value = "/srichaitanya/user/test-submission", method = RequestMethod.GET)
	public ModelAndView showTestSubmission(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/srichaitanya/tests/submit-test");
		return modelAndView;
	}

	@RequestMapping(value = "/srichaitanya/tests/{client}", method = RequestMethod.GET)
	public ModelAndView showTestsCategories(@PathVariable String client) {
		ModelAndView modelAndView = new ModelAndView();
		List<QuizGenre> quizGenres = quizService.getAllQuizGenres();
		modelAndView.addObject("quizGenres", quizGenres);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("/srichaitanya/tests/test_categories");
		return modelAndView;
	}

	@RequestMapping(value = "/srichaitanya/tests/{client}/{usersegment}/{categoryid}/{offset}", method = RequestMethod.GET)
	public ModelAndView getCategoryTests(@PathVariable String client,
			@PathVariable int categoryid, @PathVariable int offset,
			@PathVariable String usersegment) {
		ModelAndView modelAndView = new ModelAndView();
		List<Quiz> quizList = quizService.getQuizzesBasedOnClient(client,
				categoryid, offset, 10, usersegment);
		int totalQuizCount = quizService.getQuizzesCountBasedOnClient(client,
				categoryid, usersegment);
		modelAndView.addObject("quizList", quizList);
		modelAndView.addObject("usersegment", usersegment);
		modelAndView.addObject("offset", offset);
		modelAndView.addObject("categoryid", categoryid);
		modelAndView.addObject("totalQuizCount", totalQuizCount);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("/srichaitanya/tests/user_tests");
	
		return modelAndView;
	}

	@RequestMapping(value = "/srichaitanya/user/taketest/{id}", method = RequestMethod.GET)
	public ModelAndView takeTest(@PathVariable int id, HttpSession session) {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		//boolean isPremium = isStudentPremium(userData);
		ModelAndView modelAndView = new ModelAndView();
		int testsCount=quizService.getStudentDayQuizCount(userData.getUsername());
		System.out.println("testsCount"+testsCount);
		//if (isPremium ||  testsCount< 3) {
			Quiz quiz = quizService.getQuiz(id);
			LinkedHashMap<String, List<String>> quizBuild = MsbUtil.buildQuiz(
					quiz.getQuestions(), quiz.getKeyset());

			/* check whether user taken the test or not */
			boolean isTestTaken = quizService.isStudenTakentest(quiz.getId(),
					userData.getUsername());

			/* get user segment */
			String user_segment = MsbUtil
					.getUserSegmentBasedOnClassStudyingForTests(userData
							.getStandard());

			/* check whether user segment and quiz category is same or not */
			boolean testAndUserSegmentSame = MsbUtil
					.isUserSegmentSameAsTestCategory(user_segment,
							quiz.getCategory());

			modelAndView.addObject("isUserCategory", testAndUserSegmentSame);
			modelAndView.addObject("isTestTaken", isTestTaken);
			modelAndView.addObject("quizBuild", quizBuild);
			modelAndView.addObject("quiz", quiz);
			modelAndView.setViewName("/srichaitanya/tests/take-test");
		//} else {
			//modelAndView.setViewName("/srichaitanya/tests/test-count-exceeded");
		//}
		return modelAndView;
	}

	@RequestMapping(value = "/srichaitanya/user/submittest/{id}", method = RequestMethod.POST)
	public String submitTest(@PathVariable int id,
			@RequestParam Map<String, String> paramsMap,
			RedirectAttributes redirectAttributes, HttpSession session) {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
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
			userService.updateUserDetails(userData);
			

		}
		
		//if(!isStudentPremium(userData)){
			quizService.updateStudentDayQuizCount(userData.getUsername());
			System.out.println("Update Day test count");
		//}
		return "redirect:/srichaitanya/user/test-submission";

	}

	//private boolean isStudentPremium(SchoolUser userData) {
		//if (userData.getIsPremium() == 1) {
			//System.out.println("Premium account");
			//return true;
		//} else if (userData.getPremium_trail_subscribed() == 1) {
			//if (!MsbUtil.isPremiumTrailExpired(userData
					//.getTrailperiod_end_date())) {
				//System.out.println("Trial Period");
				//return true;
			//}
		//}
		//System.out.println("No Premium");
		//return false;
	//}
	
	
	
	
	
	/* School test controller starts */
	
	@RequestMapping(value = "/school/user/test-submission", method = RequestMethod.GET)
	public ModelAndView showSchoolTestSubmission(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/school/tests/submit-test");
		return modelAndView;
	}

	@RequestMapping(value = "/school/tests/{client}", method = RequestMethod.GET)
	public ModelAndView showSchoolTestsCategories(@PathVariable String client) {
		ModelAndView modelAndView = new ModelAndView();
		List<QuizGenre> quizGenres = quizService.getAllQuizGenres();
		modelAndView.addObject("quizGenres", quizGenres);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("/school/tests/test_categories");
		return modelAndView;
	}

	@RequestMapping(value = "/school/tests/{client}/{usersegment}/{categoryid}/{offset}", method = RequestMethod.GET)
	public ModelAndView getSchoolCategoryTests(@PathVariable String client,
			@PathVariable int categoryid, @PathVariable int offset,
			@PathVariable String usersegment) {
		ModelAndView modelAndView = new ModelAndView();
		List<Quiz> quizList = quizService.getQuizzesBasedOnClient(client,
				categoryid, offset, 10, usersegment);
		int totalQuizCount = quizService.getQuizzesCountBasedOnClient(client,
				categoryid, usersegment);
		modelAndView.addObject("quizList", quizList);
		modelAndView.addObject("usersegment", usersegment);
		modelAndView.addObject("offset", offset);
		modelAndView.addObject("categoryid", categoryid);
		modelAndView.addObject("totalQuizCount", totalQuizCount);
		modelAndView.addObject("client", client);
		modelAndView.setViewName("/school/tests/user_tests");
	
		return modelAndView;
	}

	@RequestMapping(value = "/school/user/taketest/{id}", method = RequestMethod.GET)
	public ModelAndView takeSchoolTest(@PathVariable int id, HttpSession session) {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		//boolean isPremium = isStudentPremium(userData);
		ModelAndView modelAndView = new ModelAndView();
		int testsCount=quizService.getStudentDayQuizCount(userData.getUsername());
		System.out.println("testsCount"+testsCount);
		//if (isPremium ||  testsCount< 3) {
			Quiz quiz = quizService.getQuiz(id);
			LinkedHashMap<String, List<String>> quizBuild = MsbUtil.buildQuiz(
					quiz.getQuestions(), quiz.getKeyset());

			/* check whether user taken the test or not */
			boolean isTestTaken = quizService.isStudenTakentest(quiz.getId(),
					userData.getUsername());

			/* get user segment */
			String user_segment = MsbUtil
					.getUserSegmentBasedOnClassStudyingForTests(userData
							.getStandard());

			/* check whether user segment and quiz category is same or not */
			boolean testAndUserSegmentSame = MsbUtil
					.isUserSegmentSameAsTestCategory(user_segment,
							quiz.getCategory());

			modelAndView.addObject("isUserCategory", testAndUserSegmentSame);
			modelAndView.addObject("isTestTaken", isTestTaken);
			modelAndView.addObject("quizBuild", quizBuild);
			modelAndView.addObject("quiz", quiz);
			modelAndView.setViewName("/school/tests/take-test");
		//} else {
			//modelAndView.setViewName("/srichaitanya/tests/test-count-exceeded");
		//}
		return modelAndView;
	}

	@RequestMapping(value = "/school/user/submittest/{id}", method = RequestMethod.POST)
	public String submitSchoolTest(@PathVariable int id,
			@RequestParam Map<String, String> paramsMap,
			RedirectAttributes redirectAttributes, HttpSession session) {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
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
			userService.updateUserDetails(userData);
			

		}
		
		//if(!isStudentPremium(userData)){
			quizService.updateStudentDayQuizCount(userData.getUsername());
			System.out.println("Update Day test count");
		//}
		return "redirect:/school/user/test-submission";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
