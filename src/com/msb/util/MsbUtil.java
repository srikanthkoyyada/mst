package com.msb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.web.multipart.MultipartFile;

import com.msb.bean.StudentCompetitionPoints;
import com.msb.bean.StudentQuizPoints;
import com.msb.constants.MsbConstants;
import com.msb.model.Other;

public class MsbUtil {

	public static Date getCurrentDate() {

		java.util.Date today = new java.util.Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String IST = df.format(today);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = format.parse(IST);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date currentDate = new java.sql.Date(utilDate.getTime());
		return currentDate;

	}

	public static Date getExpDt() {

		Calendar calender = Calendar.getInstance(TimeZone.getTimeZone("IST"),
				Locale.ENGLISH);
		calender.add(Calendar.YEAR, 1);
		long time = calender.getTimeInMillis();
		Date expdt = new Date(time);
		System.out.println("Expiry Date is " + expdt);
		return expdt;

	}

	public static Date getPremiumExpDt() {

		Calendar calender = Calendar.getInstance(TimeZone.getTimeZone("IST"),
				Locale.ENGLISH);
		calender.add(Calendar.DAY_OF_MONTH, 7);
		long time = calender.getTimeInMillis();
		Date expdt = new Date(time);
		System.out.println("Premium Expiry Date is " + expdt);
		return expdt;

	}

	public static String getActivationCode() {

		String aCode = UUID.randomUUID().toString();

		System.out.println("Activation code is : " + aCode);
		return aCode;
	}

	public static String buildStudentRegistrationMail(Other other,
			String activationCode) {
		String body = "<div class=\"well\">"
				+ "<div class=\"row\"><img src=\"mysuperbrain.com/assets/logo.png\" alt=\"Logo\" height=\"239px\" width=\"463px\"></div>"
				+ "<div class=\"row\"><div class=\"col-md-1\"></div><div class=\"col-md-10\">"
				+ "<h3><font face='tahoma, sans-serif'>Welcome to MySuperBrain "
				+ " !</font></h3>" + "<p>You have registered with the Username as <b>"
				+ other.getUsername()
				+ "</b></p>"
				+ "<p>Thanks for your interest in joining MySuperBrain.in, the largest platform for Talent Discovery in the World. You need to now activate your account.</p>"
				+ "<p>Please click the below activation link to activate your account :</p>"
				+ "<a href=\"http://mysuperbrain.in/studentactivation/"
				+ activationCode
				+ "\">Activate MySuperBrain Account</a>"
				+ "<p>For future reference, we are sharing the details you	provided us with :</p>"
				+ "<br>"
				+ "<div class=\"col-md-2\"></div>"
				+ "<table>"
				+ "<thead></thead>"
				+ "<tbody>"
				+ "<tr><td>Other Name :</td><td>"
				+ other.getUsername()
				+ "</td></tr>"
				+ "<tr><td>Other Password :</td><td>"
				+ other.getPassword()
				+ "</td></tr>"

				+ "<tr><td>Email ID :</td><td>"
				+ other.getMail()
				+ "</td></tr>"
				+ "<tr><td>Mobile/Phone Number :</td><td>"
				+ other.getPhone()
				+ "</td></tr>"

				+ "</tbody>"
				+ "</table>"
				+ "<br>"
				+ "<p>On MySuperBrain.in, any student can Discover, Improve and Showcase his/ her talents to the world.</p>"
				+ "<p>If you need assistance or have any queries, feel free to call us up at 97013 20902</p>"
				+ "<p>You can also email us at <a href=\"#\">contact@mysuperbrain.com</a> and our team will get in touch with you as soon as possible.</p>"
				+ "<h3><font face='tahoma, sans-serif'>All the best !</font></h3>"
				+ "<p>At your service</p>"
				+ "<p>Team MSB.</p>" + "</div>" + "</div>" + "</div>";
		return body;
	}

	public static String buildStudentReferralMail(Other other) {
		String TEXT = "Dear Friend,\n"
				+ "<p>As you know, I have always wanted to Discover, Improve and Showcase my skills on a global platform. It has also been the case with you. I have come across www.MySuperBrain.com which is an amazing platform for school students like us.</p> "
				+ "<p>We can participate in Quizzes, Competitions, play educational games and improve our knowledge. MSB has competitions in many areas like:</p>"
				+ "a.Writing"
				+ "<br/>"
				+ "b.Painting"
				+ "<br/>"
				+ "c.Singing"
				+ "<br/>"
				+ "d.Dance"
				+ "<br/>"
				+ "e.Projects"
				+ "<br/>"

				+ "g.Photography etc"
				+ "<br/>"
				+ "<p>Whenever we submit entries, they are open for everyone to view and vote. You, me, our families or friends, teachers and even people that we never meet or know can look at our amazing creations and support us and get us points. We can check how we fare against students from across the world. </p>"
				+ "<p>What are you waiting for? Come join me and thousands of other students from across the world and let the world know what you are capable of.</p>"
				+ "Thanks,<br/>" + other.getUsername();
		return TEXT;
	}

	public static int getCompetitionCategoryID(String categoryName) {

		if ("writing".equalsIgnoreCase(categoryName))
			return MsbConstants.WRITING_COMPETITION;
		if ("painting".equalsIgnoreCase(categoryName))
			return MsbConstants.PAINTING_COMPETITION;
		if ("poetry".equalsIgnoreCase(categoryName))
			return MsbConstants.POETRY_COMPETITION;
		if ("dance".equalsIgnoreCase(categoryName))
			return MsbConstants.DANCE_COMPETITION;
		if ("music".equalsIgnoreCase(categoryName))
			return MsbConstants.MUSIC_COMPETITION;
		if ("speaking".equalsIgnoreCase(categoryName))
			return MsbConstants.SPEAKING_COMPETITION;
		if ("cooking".equalsIgnoreCase(categoryName))
			return MsbConstants.COOKING_COMPETITION;
		if ("uat".equalsIgnoreCase(categoryName))
			return MsbConstants.UAT_COMPETITION;
		return 0;

	}

	public static String getUserSegmentBasedOnClassStudyingForTests(
			int standard) {

		if (standard==1 || standard==2 || standard==3)
			return "KID";
		if (standard==4 || standard==5 || standard==6)
			return "JUN";
		if (standard==7 || standard==8 || standard==9)
			return "SEN";
		if (standard==10 || standard==11 || standard==12)
			return "SSEN";
		return null;

	}

	public static String getUserSegmentBasedOnClassStudyingForEMagazine(
			String standard) {

		if ("lkg".equalsIgnoreCase(standard))
			return "LG";
		if ("ukg".equalsIgnoreCase(standard))
			return "LG";
		if ("one".equalsIgnoreCase(standard))
			return "KID";
		if ("two".equalsIgnoreCase(standard))
			return "KID";
		if ("three".equalsIgnoreCase(standard))
			return "KID";
		if ("four".equalsIgnoreCase(standard))
			return "JUN";
		if ("five".equalsIgnoreCase(standard))
			return "JUN";
		if ("six".equalsIgnoreCase(standard))
			return "JUN";
		if ("seven".equalsIgnoreCase(standard))
			return "SEN";
		if ("eight".equalsIgnoreCase(standard))
			return "SEN";
		if ("nine".equalsIgnoreCase(standard))
			return "SEN";
		if ("ten".equalsIgnoreCase(standard))
			return "SEN";

		return "JUN";

	}
	
	public static boolean isCompetitionStarted(String competitionOpenDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date competitionStartdate = null;
		try {
			competitionStartdate = df.parse(competitionOpenDate);

			java.util.Date today = new java.util.Date();
			if (df.parse(df.format(today)).before(competitionStartdate)) {
				return true;
			} else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isCompetitionClosed(String competitionEndDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date competitionLastdate = null;
		try {
			competitionLastdate = df.parse(competitionEndDate);

			java.util.Date today = new java.util.Date();
			if (df.parse(df.format(today)).after(competitionLastdate)) {
				return true;
			} else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isPremiumTrailExpired(java.util.Date premiumEndDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date today = new java.util.Date();
			if (df.parse(df.format(today)).after(premiumEndDate)) {
				return true;
			} else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

	public static String readWordDocument(String filepath, String filename)
			throws IOException {

		FileInputStream fs = null;
		StringBuilder textEntry = new StringBuilder();
		XWPFDocument documentx = null;
		HWPFDocument document = null;
		WordExtractor wordExtractor = null;
		try {
			fs = new FileInputStream(filepath);
			if (fs.available() >= 512) {

				if (filename.endsWith("docx")) {

					documentx = new XWPFDocument(fs);

					List<XWPFParagraph> paragraphs = documentx.getParagraphs();

					for (XWPFParagraph para : paragraphs) {
						textEntry.append("<p>" + para.getText() + "</p>");
					}

				} else if (filename.endsWith("doc")) {

					document = new HWPFDocument(fs);
					wordExtractor = new WordExtractor(document);

					String[] paragraphs = wordExtractor.getParagraphText();

					for (int i = 0; i < paragraphs.length; i++) {

						textEntry.append("<p>" + paragraphs[i] + "</p>");
					}

				}

				return textEntry.toString();
			} else {
				return "Other did not provided valid content";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fs != null)
				fs.close();
			if (documentx != null)
				documentx.close();
			if (wordExtractor != null)
				wordExtractor.close();

		}
		return null;
	}

	public static boolean isDateIsToday(String likeDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date likedate = null;
		try {
			likedate = df.parse(likeDate);

			java.util.Date today = new java.util.Date();
			if (df.parse(df.format(today)).equals(likedate)) {
				return true;
			} else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static LinkedHashMap<String, List<String>> buildQuiz(
			String questions, String keySet) {
		LinkedHashMap<String, List<String>> quiz = new LinkedHashMap<String, List<String>>();

		if (questions != null && keySet != null) {
			String[] quizArr = questions.split("\\?");
			String[] answrs = keySet.split("\\?");

			for (int i = 0; i < quizArr.length; i++) {
				String[] spcfcKey = answrs[i].split("!");
				quiz.put(quizArr[i], Arrays.asList(spcfcKey));
			}

		}

		for (Entry<String, List<String>> entry : quiz.entrySet()) {
			System.out.println(entry.getKey() + ":::" + entry.getValue());
		}
		return quiz;

	}

	public static Time convertStringToSqlTime(String time) {
		java.sql.Time sqlTime = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			java.util.Date utilDate = format.parse(time);
			long t = utilDate.getTime();
			sqlTime = new Time(t);
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return sqlTime;
	}

	public static Time getSqlTimeDiff(String totalTime, String balTime) {
		long hours = 0, minutes = 0, seconds = 0;
		try {
			java.sql.Time oldTime = java.sql.Time.valueOf(totalTime);
			java.sql.Time currentTime = java.sql.Time.valueOf(balTime);
			long milliseconds1 = oldTime.getTime();
			long milliseconds2 = currentTime.getTime();
			long diff = milliseconds2 - milliseconds1;
			long diffSeconds = diff / 1000;
			hours = Math.abs(diffSeconds) / 3600;
			minutes = (Math.abs(diffSeconds) % 3600) / 60;
			seconds = Math.abs(diffSeconds) % 60;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return convertStringToSqlTime(hours + ":" + minutes + ":" + seconds);
	}

	public static boolean isUserSegmentSameAsTestCategory(String user_segment,
			String test_categroy) {

		if (user_segment.equals("KID")) {
			return true;
		} else if (user_segment.equals("JUN")) {
			if (test_categroy.equals("JUN") || test_categroy.equals("SEN"))
				return true;
		} else if (user_segment.equals("SEN")) {
			if (test_categroy.equals("SEN") || test_categroy.equals("SSEN"))
				return true;
		} else if (user_segment.equals("SSEN")) {
			if (test_categroy.equals("SSEN"))
				return true;
		}
		return false;

	}

	public static int getDifferenceInDays(java.util.Date date1,
			java.util.Date date2) {

		final long MILLIS_PER_DAY = 24 * 3600 * 1000;
		long msDiff = date1.getTime() - date2.getTime();
		long daysDiff = Math.round(msDiff / ((double) MILLIS_PER_DAY));
		return (int) daysDiff;
	}

	public static String buildCompetitionPoitsDataForChart(
			List<StudentCompetitionPoints> points) {

		StringBuilder pointsData = new StringBuilder();

		for (StudentCompetitionPoints student : points) {
			pointsData.append("[");
			pointsData.append("'");
			pointsData.append(student.getCategory());
			pointsData.append("',");
			pointsData.append(student.getTotal());
			pointsData.append("],");
			pointsData.append("\n");

		}
		System.out.println(pointsData.toString());
		return pointsData.toString();
	}

	public static String buildQuizPoitsDataForChart(
			List<StudentQuizPoints> points) {

		StringBuilder pointsData = new StringBuilder();

		for (StudentQuizPoints student : points) {
			pointsData.append("[");
			pointsData.append("'");
			pointsData.append(student.getGenre());
			pointsData.append("',");
			pointsData.append(student.getTotal_points());
			pointsData.append("],");
			pointsData.append("\n");

		}
		System.out.println(pointsData.toString());
		return pointsData.toString();
	}

	public static Integer getStudentTotalQuizPoints(
			List<StudentQuizPoints> points) {

		Integer totalPoints = 0;

		for (StudentQuizPoints student : points) {

			totalPoints = totalPoints + student.getTotal_points();

		}
		System.out.println(totalPoints);
		return totalPoints;
	}
	
	public static String buildMskSubmissionMail(String username,
			int id) {
		String body = "<div style='background-color: #d9edf7; border-color: #bce8f1; color: #31708f; padding: 15px; margin-bottom: 20px; border: 1px solid transparent;'>"
				+"<p>&nbsp;</p>"
				+"<img src='http://mysuperbrain.in/img/msk.png' style='width: 100%'"
				+"<hr><p>&nbsp;</p>"
				+ "<h3>Dear Parent, "
				+ " !</h3>" + "<p>Thanks for participating in the My Super Kid Challenge. We are extremely happy to now showcase your child's talent to the whole world.</p>"
				+ "<p>You can view the submission here  :</p>"
				+ "<a href=\"http://mysuperbrain.in/view/mysuperkid/competition_msk/"
				+ id
				+ "\">www.mysuperbrain.in/view/mysuperkid/competition_msk/"
				+ id
				+ "</a>"
				+ "<br>"
				+ "<p>You can promote it on social media to get more people to recognize your child's talents. We will send you weekly updates about the recognition your kid is getting and we are sure you would be the happiest parent soaking in all the adulation.</p>"
				+ "<p>We request you to invite 3 parents to participate in this #mysuperkid challenge so that we can have millions of parents sharing the talents of their kids and building a society where every dream is realized and every talent nurtured.</p>"
				+ "<h3>All the best !</h3>"
				+ "<p>Thanks & Regards,</p>"
				+ "<p>Team MySuperBrain.</p>" + "</div>";
		return body;
	}
	
	public static boolean isSCExpired(java.util.Date premiumEndDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			java.util.Date today = new java.util.Date();
			if (df.parse(df.format(today)).after(premiumEndDate)) {
				return true;
			} else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	public static String buildStudentRegistrationMail1(Other other,
			String activationCode) {
		String body = "<div class=\"well\">"
				+ "<div class=\"row\"><img src=\"mysuperbrain.com/assets/logo.png\" alt=\"Logo\" height=\"239px\" width=\"463px\"></div>"
				+ "<div class=\"row\"><div class=\"col-md-1\"></div><div class=\"col-md-10\">"
				+ "<h3><font face='tahoma, sans-serif'>Welcome to MySuperBrain "
				+ " !</font></h3>" + "<p>You have registered with the Username as <b>"
				+ other.getUsername()
				+ "</b></p>"
				+ "<p>Thanks for your interest in joining MySuperBrain.in, the largest platform for Talent Discovery in the World. You need to now activate your account.</p>"
				+ "<p>Please click the below activation link to activate your account :</p>"
				+ "<a href=\"http://mysuperbrain.in/studentactivation/"
				+ activationCode
				+ "\">Activate MySuperBrain Account</a>"
				+ "<p>For future reference, we are sharing the details you	provided us with :</p>"
				+ "<br>"
				+ "<div class=\"col-md-2\"></div>"
				+ "<table>"
				+ "<thead></thead>"
				+ "<tbody>"
				+ "<tr><td>Other Name :</td><td>"
				+ other.getUsername()
				+ "</td></tr>"
				+ "<tr><td>Other Password :</td><td>"
				+ other.getPassword()
				+ "</td></tr>"

				+ "<tr><td>Email ID :</td><td>"
				+ other.getMail()
				+ "</td></tr>"
				+ "<tr><td>Mobile/Phone Number :</td><td>"
				+ other.getPhone()
				+ "</td></tr>"

				+ "</tbody>"
				+ "</table>"
				+ "<br>"
				+ "<p>On MySuperBrain.in, any student can Discover, Improve and Showcase his/ her talents to the world.</p>"
				+ "<p>If you need assistance or have any queries, feel free to call us up at 97013 20902</p>"
				+ "<p>You can also email us at <a href=\"#\">contact@mysuperbrain.com</a> and our team will get in touch with you as soon as possible.</p>"
				+ "<h3><font face='tahoma, sans-serif'>All the best !</font></h3>"
				+ "<p>At your service</p>"
				+ "<p>Team MSB.</p>" + "</div>" + "</div>" + "</div>";
		return body;
	}
	
	public static String buildEntrySubmissionMail(String username, String entrytype, String link,
			int id) {
		String body = "<div dir='ltr'>"
				+ "<div style='text-align:center' align='center'><b><font size='4'>Dear "
				+ username
				+ ",</font></b>"
				+ "<b><font size='4'><br></font></b>"
				+ "<h3>Thank you for your participation in <i><font color='#ff0000'>My</font>"
				+ "<font color='#00ff00'>Super</font><font color='#0000ff'>Brain</font>"
				+ "<font color='#9900ff'>CARNIVAL '17</font></i>.&nbsp;</font></h3>"
				+ "<h4><br></font></h4>"
				+ "<h3>Your submission is complete!</h3>"
				+ "<b><font color='#666666' size='4'><br></font></b>"
				+ "<h4><font color='#666666'><b>Your Submission Link</b></font>: <b><font color='#0000ff'>"
				+ "<a href='"
				+ link
				+"'>"
				+ link
				+ "</a></font>&nbsp;</h4>"
				+ "<i><b>(Share this link with family &amp; friends on Facebook &amp; Whatsapp to get more people to appreciate your talent)</b></i>"
				+ "<b><br></b><br>"
				+ "<br><br><br>"
				+ "<font face='comic sans ms, sans-serif'><i><font size='4'>Amazing Prizes &amp; Gifts await you at the end of Carnival.&nbsp;</font></i></font>"
				+ "<font face='comic sans ms, sans-serif'><i><br></i></font>"
				+ "<i style='font-family:&quot;comic sans ms&quot;,sans-serif;font-size:large'>Every entry with <font color='#9900ff'>1000+ votes</font> gets a Surprise Gift!</i><br>"
				//+ "<br>"
				//+ "<font color='#0000ff'><b>How to maximize the chances of my winning?</b> </font>(page link)"
				+ "<br><br><br>"
				+ "<a href='https://www.mysuperbrain.in/carnival/premium-services'>"
				+ "<img src='https://mysuperbrain.in/img/mail/Premiumaccounthook.png' width='417' height='436' class='CToWUd a6T' tabindex='0'></a>"
				+ "<br><img src='https://mysuperbrain.in/img/mail/Talentquote2.png' width='436' height='208' class='CToWUd a6T' tabindex='0'>"
				+ "</div>"
				+ "<h3>All the best !</h3>"
				+ "<p>Thanks & Regards,</p>"
				+ "<p>Team MySuperBrain.</p>" + "</div>";
		return body;
	}
	
	public static String buildEntryViewsMail(String username, String entrytype, String link,
			int id) {
		String body = "<div dir='ltr'>"
				+ "<div style='text-align:center' align='center'><b><font size='4'>Dear "
				+ username
				+ ",</font></b>"
				+ "<b><font size='4'><br></font></b>"
				+ "<h3>Thank you for your participation in <i><font color='#ff0000'>My</font>"
				+ "<font color='#00ff00'>Super</font><font color='#0000ff'>Brain</font>"
				+ "<font color='#9900ff'>CARNIVAL '17</font></i>.&nbsp;</font></h3>"
				+ "<h4><br></font></h4>"
				+ "<h3>Your submission is complete!</h3>"
				+ "<b><font color='#666666' size='4'><br></font></b>"
				+ "<h4><font color='#666666'><b>Your Submission Link</b></font>: <b><font color='#0000ff'>"
				+ "<a href='"
				+ link
				+"'>"
				+ link
				+ "</a></font>&nbsp;</h4>"
				+ "<i><b>(Share this link with family &amp; friends on Facebook &amp; Whatsapp to get more people to appreciate your talent)</b></i>"
				+ "<b><br></b><br>"
				+ "<br><br><br>"
				+ "<font face='comic sans ms, sans-serif'><i><font size='4'>Amazing Prizes &amp; Gifts await you at the end of Carnival.&nbsp;</font></i></font>"
				+ "<font face='comic sans ms, sans-serif'><i><br></i></font>"
				+ "<i style='font-family:&quot;comic sans ms&quot;,sans-serif;font-size:large'>Every entry with <font color='#9900ff'>1000+ votes</font> gets a Surprise Gift!</i><br>"
				//+ "<br>"
				//+ "<font color='#0000ff'><b>How to maximize the chances of my winning?</b> </font>(page link)"
				+ "<br><br><br>"
				+ "<a href='https://www.mysuperbrain.in/carnival/premium-services'>"
				+ "<img src='https://mysuperbrain.in/img/mail/Premiumaccounthook.png' width='417' height='436' class='CToWUd a6T' tabindex='0'></a>"
				+ "<br><img src='https://mysuperbrain.in/img/mail/Talentquote2.png' width='436' height='208' class='CToWUd a6T' tabindex='0'>"
				+ "</div>"
				+ "<h3>All the best !</h3>"
				+ "<p>Thanks & Regards,</p>"
				+ "<p>Team MySuperBrain.</p>" + "</div>";
		return body;
	}
	
	public static String buildEntryLikesMail(String username, String entrytype) {
		String body = "<div dir='ltr'>"
				+ "<div style='text-align:center' align='center'><b><font size='4'>Dear "
				+ username
				+ ",</font></b>"
				+ "<b><font size='4'><br></font></b>"
				+ "<h3>Thank you for your participation in <i><font color='#ff0000'>My</font>"
				+ "<font color='#00ff00'>Super</font><font color='#0000ff'>Brain</font>"
				+ "<font color='#9900ff'>CARNIVAL '17</font></i>.&nbsp;</font></h3>"
				+ "<h4><br></font></h4>"
				+ "<h3>Your submission is complete!</h3>"
				+ "<b><font color='#666666' size='4'><br></font></b>"
				+ "<i><b>(Share this link with family &amp; friends on Facebook &amp; Whatsapp to get more people to appreciate your talent)</b></i>"
				+ "<b><br></b><br>"
				+ "<br><br><br>"
				+ "<font face='comic sans ms, sans-serif'><i><font size='4'>Amazing Prizes &amp; Gifts await you at the end of Carnival.&nbsp;</font></i></font>"
				+ "<font face='comic sans ms, sans-serif'><i><br></i></font>"
				+ "<i style='font-family:&quot;comic sans ms&quot;,sans-serif;font-size:large'>Every entry with <font color='#9900ff'>1000+ votes</font> gets a Surprise Gift!</i><br>"
				//+ "<br>"
				//+ "<font color='#0000ff'><b>How to maximize the chances of my winning?</b> </font>(page link)"
				+ "<br><br><br>"
				+ "<a href='https://www.mysuperbrain.in/carnival/premium-services'>"
				+ "<img src='https://mysuperbrain.in/img/mail/Premiumaccounthook.png' width='417' height='436' class='CToWUd a6T' tabindex='0'></a>"
				+ "<br><img src='https://mysuperbrain.in/img/mail/Talentquote2.png' width='436' height='208' class='CToWUd a6T' tabindex='0'>"
				+ "</div>"
				+ "<h3>All the best !</h3>"
				+ "<p>Thanks & Regards,</p>"
				+ "<p>Team MySuperBrain.</p>" + "</div>";
		return body;
	}
	
	public static String buildStudentEntryShareMail(String username, String link) {
		String body = "<div dir='ltr'>"
				+ "<div style='text-align:center' align='center'><b><font size='4'>Dear Friend"
				+ ",</font></b>"
				+ "<b><font size='4'><br></font></b>"
				+ "<h3>Your friend, "
				+ username
				+ " &nbsp;has participated in a competiton at <i><font color='#ff0000'>My</font>"
				+ "<font color='#00ff00'>Super</font><font color='#0000ff'>Brain</font></h3>"
				+ "<h4><br></font></h4>"
				+ "<h3>He/She has submitted an entry and wants share it with you!</h3>"
				+ "<b><font color='#666666' size='4'><br></font></b>"
				+ "<p><a href='"
				+ link
				+ "'>"
				+ link
				+ "</a></p>"
				+ "<p><i><b>(Like/Vote to appreciate his/her talent)</b></i></p>"
				+ "<b><br></b><br>"
				+ "<br><br><br>"
				+ "<i style='font-family:&quot;comic sans ms&quot;,sans-serif;font-size:large'>Every entry with <font color='#9900ff'>1000+ votes</font> gets a Surprise Gift!</i><br>"
				//+ "<br>"
				//+ "<font color='#0000ff'><b>How to maximize the chances of my winning?</b> </font>(page link)"
				+ "<br><br><br>"
				+ "<a href='https://www.mysuperbrain.in/carnival/premium-services'>"
				+ "<img src='https://mysuperbrain.in/img/mail/Premiumaccounthook.png' width='417' height='436' class='CToWUd a6T' tabindex='0'></a>"
				+ "</div>"
				+ "<h3>All the best !</h3>"
				+ "<p>Thanks & Regards,</p>"
				+ "<p>Team MySuperBrain.</p>" + "</div>";
		return body;
	}
	
}
