package com.msb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.Competition;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.UploadATalent;
import com.msb.model.SchoolUser;
import com.msb.service.CompetitionService;
import com.msb.service.MailService;
import com.msb.service.SchoolUserService;
import com.msb.util.MsbUtil;
import com.msb.validator.TextCompetitionValidator;

@Controller
public class SchoolCompetitionsController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	CompetitionService competitionService;

	@Autowired
	SchoolUserService otherService;

	@Autowired
	MailService mailService;

	@Autowired
	TextCompetitionValidator textCompetitionValidator;

	@RequestMapping(value = "/school/competitions", method = RequestMethod.GET)
	public String competitions() {
		return "/school/competitions/competitions";
	}

	@RequestMapping(value = "/school/competition_list", method = RequestMethod.GET)
	public String competitionsList() {
		return "/school/competitions/competition_list";
	}
	
	@RequestMapping(value = "/school/{competition_type}/competition-list", method = RequestMethod.GET)
	public ModelAndView getCompetitions(
			@PathVariable(value = "competition_type") String competition_type) {

		List<Competition> competitions = competitionService
				.getCompetitionsForSchool(
						MsbUtil.getCompetitionCategoryID(competition_type));
		System.out.println("Comp category :" +MsbUtil.getCompetitionCategoryID(competition_type));

		if (competitions != null && competitions.size() > 0) {
			ModelAndView modelAndView = new ModelAndView();

			modelAndView.addObject("competition_type", competition_type);
			modelAndView.addObject("competitionList", competitions);
			
			modelAndView.setViewName("/school/competitions/competition_list");
			return modelAndView;
		} else{
			
				return new ModelAndView("redirect:/school/competition_list?success=false&cat="+competition_type+"");
		}
			

	}

	@RequestMapping(value = "/school/competitions/{client}", method = RequestMethod.GET)
	public ModelAndView competitions(
			@PathVariable(value = "client") String client) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("client", client);
		
		modelAndView.setViewName("/school/competitions/competitions");
		return modelAndView;

	}

	@RequestMapping(value = "/school/user/mst_competition_saved", method = RequestMethod.GET)
	public String paintingCompetitionSaved() {
		return "/school/competitions/mst_competition_saved";
	}

	@RequestMapping(value = "/school/user/text-competition-saved", method = RequestMethod.GET)
	public String textCompetitionSaved() {
		return "/school/competitions/text_competition_saved";
	}

	@RequestMapping(value = "/school/user/upload_a_talent_saved", method = RequestMethod.GET)
	public String wiytCompetitionSaved() {
		return "/school/competitions/upload_a_talent_saved";
	}

	@RequestMapping(value = "/school/user/{type}/text_competition/{id}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView competitionsSubmissionForm(
			@PathVariable("id") String id,@PathVariable("client") String client,
			@PathVariable("type") String type, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Competition competition = competitionService
				.getCompetitionDetails(Integer.parseInt(id));
		if (competition != null) {
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
			competitionService.updateCompetitionVisits(competition);
			
			modelAndView.addObject("client", client);
			modelAndView.addObject("type", type);
			modelAndView.addObject("competition", competition);
			modelAndView.setViewName("/school/competitions/text_competition");
			return modelAndView;
		} else
			return new ModelAndView("redirect:/competitions?success=false");
	}

	@RequestMapping(value = "/school/user/{type}/competition/{id}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView mstCompetitionsSubmissionForm(
			@PathVariable("id") String id,
			@PathVariable("type") String type, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Competition competition = competitionService
				.getCompetitionDetails(Integer.parseInt(id));
		if (competition != null) {
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
			//competitionService.updateCompetitionVisits(competition);

			modelAndView.addObject("type", type);
			modelAndView.addObject("competition", competition);
			modelAndView.setViewName("/school/competitions/mst_competition");
			return modelAndView;
		} else
			return new ModelAndView("redirect:/competitions?success=false");
	}
	
	/*
	 * @RequestMapping(value = "/school/user/mst_competition/dance", method = {
	 * RequestMethod.POST, RequestMethod.GET }) public ModelAndView
	 * danceSubmissionForm( HttpSession session) { ModelAndView modelAndView = new
	 * ModelAndView();
	 * 
	 * 
	 * Other userData = (Other) session.getAttribute("Student");
	 * 
	 * 
	 * Integer user_total_competition_submissions = competitionService
	 * .getUserTotalSubmissions( userData.getUsername(), "Dance"); if
	 * (user_total_competition_submissions > 3)
	 * modelAndView.addObject("submissions_exceeded", true); else
	 * modelAndView.addObject("submissions_exceeded", false);
	 * modelAndView.addObject("type", "Dance");
	 * modelAndView.setViewName("/school/competitions/mst_competition");
	 * 
	 * return modelAndView; }
	 */

	@RequestMapping(value = "/school/user/upload_a_talent", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView uatSubmissionForm(
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		
		modelAndView.setViewName("/school/competitions/upload_a_talent");
		return modelAndView;

	}

	@RequestMapping(value = "/school/user/submit-text-competition", method = RequestMethod.POST)
	public ModelAndView submitCompetitionText(
			@ModelAttribute("competitionText") CompetitionText competitionText,
			HttpSession session, BindingResult result) throws IOException {
			textCompetitionValidator.validate(competitionText, result);
		if (!result.hasErrors()) {
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");

			//Integer user_total_competition_submissions = competitionService
					//.getUserTotalTextSubmissions(
							//userData.getUsername(),
							//competitionText.getEntry_type());
			//if (user_total_competition_submissions >= 3)
				//return new ModelAndView(
							//"redirect:/school/user/text-competition-saved?"+competitionText.getEntry_type()+"&success=false&exceeded=true");
			//else {
				competitionText.setUser_name(userData.getUsername());
				Integer id = competitionService
						.saveTextCompetition(competitionText);
				if (id != 0) {
					
					userData.setPoints(userData.getPoints()+20);
					otherService.updateUserDetails(userData);
					//String subject = "Thank You For Participating at MySuperBrain";
					//String entrytype = "Text";
					//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_textentry/"+id;
					//String body = MsbUtil.buildEntrySubmissionMail(userData.getUsername(), entrytype, link, id);
					//mailService.sendMail(subject, body, userData.getMail(), false, "Submitted Your Entry Successfully");
					return new ModelAndView(
							"redirect:/school/user/text-competition-saved?type="+competitionText.getEntry_type()+"&success=true&id="
									+ id);
				} else
					return new ModelAndView(
							"redirect:/school/user/text-competition-saved?type="+competitionText.getEntry_type()+"&success=false");
			//}
		} else {
			return new ModelAndView("redirect:/school/user/text_competition/"
					+ competitionText.getEntry_type()
					+ "?success=false&input=false");
		}

	}
	
	@RequestMapping(value = "/school/user/submit-mst-competition", method = RequestMethod.POST)
	public ModelAndView submitSinging(
			@ModelAttribute("mst") MSTCompetition mst,
			HttpSession session,
			@RequestParam(value = "mst_video", required = true) MultipartFile mst_video)
			throws IOException {
		
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");

			mst.setUser_name(userData.getUsername());

			String filename = userData.getUsername() + "_"
					+ competitionService.getMstMaxID() + "."
					+ mst_video.getOriginalFilename().split("\\.")[1];
			mst.setSubmission_file_name(filename);
			Integer id = competitionService.saveMSTCompetition(mst);

			if (id != 0) {
				uploadFile(filename, mst_video, mst.getSubmission_type());
				userData.setPoints(userData.getPoints()+20);
				otherService.updateUserDetails(userData);
				//String subject = "Thank You For Participating at MySuperBrain";
				//String entrytype = "Singing";
				//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_music/"+id;
				//String body = MsbUtil.buildEntrySubmissionMail(userData.getUsername(), entrytype, link, id);
				//mailService.sendMail(subject, body, userData.getMail(), false, "Submitted Your Entry Successfully");
				return new ModelAndView(
						"redirect:/school/user/mst_competition_saved?type="+mst.getSubmission_type()+"&success=true&id="
								+ id);
			} else
				return new ModelAndView(
						"redirect:/school/user/mst_competition_saved?type="+mst.getSubmission_type()+"&success=false");
		

	}

	@RequestMapping(value = "/school/user/submit-uat-competition", method = RequestMethod.POST)
	public ModelAndView submitUploadATalent(
			@ModelAttribute("uat") UploadATalent uat,
			HttpSession session,
			@RequestParam(value = "uat_attachment", required = true) MultipartFile uat_attachment)
			throws IOException {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (uat.getEntry_type().equalsIgnoreCase("text")) {
			uat.setUser_name(userData.getUsername());
			uat.setContent(uat.getContent());
			Integer id = competitionService.saveUploadATalent(uat);
			if (id != 0) {
				userData.setPoints(userData.getPoints()+20);
				otherService.updateUserDetails(userData);
				return new ModelAndView(
						"redirect:/school/user/upload_a_talent_saved?success=true&id="
								+ id);
			} else
				return new ModelAndView(
						"redirect:/school/user/upload_a_talent_saved?success=false");
		} else {

			uat.setUser_name(userData.getUsername());

			String filename = userData.getUsername() + "_"
					+ competitionService.getUploadATalentMaxID() + "."
					+ uat_attachment.getOriginalFilename().split("\\.")[1];
			uat.setEntry_file_name(filename);
			Integer id = competitionService.saveUploadATalent(uat);

			if (id != 0) {
				uploadFile(filename, uat_attachment, "UAT");
				userData.setPoints(userData.getPoints()+20);
				otherService.updateUserDetails(userData);
				//String subject = "Thank You For Participating at MySuperBrain";
				//String entrytype = "What is your Talent";
				//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_wiyt/"+id;
				//String body = MsbUtil.buildEntrySubmissionMail(userData.getUsername(), entrytype, link, id);
				//mailService.sendMail(subject, body, userData.getMail(), false, "Submitted Your Entry Successfully");
				return new ModelAndView(
						"redirect:/school/user/upload_a_talent_saved?success=true&id="
								+ id);
			} else
				return new ModelAndView(
						"redirect:/school/user/upload_a_talent_saved?success=false");
		}

	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	private void uploadFile(String filename, MultipartFile image,
			String competition) {
		File image_path = new File(servletContext.getRealPath("/")
				+ "user_images/Comp_Sub/" + competition + "/" + filename);
		image_path.getParentFile().mkdirs();
		try {
			FileUtils.writeByteArrayToFile(image_path, image.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/*individual competition info page controllers starts*/

	@RequestMapping(value = "/{client}/competition_info/{id}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView competionInfo(@PathVariable("id") String id,
			@PathVariable("client") String client) {
		ModelAndView modelAndView = new ModelAndView();
		Competition competition = competitionService
				.getCompetitionDetails(Integer.parseInt(id));
		//competition.setNo_of_visits(competition.getNo_of_visits() + 1);
		competitionService.updateCompetitionVisits(competition);
		if (competition != null) {
			

			modelAndView.addObject("client", client);
			modelAndView.addObject("competition", competition);
			
			modelAndView.setViewName("/school/competitions/competition_info");
			
			return modelAndView;
		} else
			
			return new ModelAndView("redirect:/school/competitions?success=false");

	}

}
