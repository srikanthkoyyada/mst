package com.msb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.msb.model.BlogArticle;
import com.msb.model.CollegeUser;
import com.msb.model.Competition;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.SchoolUser;
import com.msb.model.UserLikeValidation;
import com.msb.model.SchoolUser.SaveUser;
import com.msb.service.CompetitionService;
import com.msb.service.OtherService;
import com.msb.service.QuizService;
import com.msb.service.SchoolUserService;
import com.msb.util.MsbUtil;
import com.msb.validator.RegisterValidator;
import com.msb.validator.SchoolRegisterValidator;

@Controller
public class SingerHomeController {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	RegisterValidator registerValidator;
	
	@Autowired
	private SchoolUserService userService;
	
	@Autowired
	private OtherService otherService;
	
	@Autowired
	private CompetitionService competitionService;

	@RequestMapping(value = "/singer", method = RequestMethod.GET)
	public String home(ModelMap map) {
		return "/singer/index";
	}
	
	@RequestMapping(value = "/singer/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		return "/singer/index";
	}
	
	@RequestMapping(value = "/riyaz", method = RequestMethod.GET)
	public ModelAndView riyaz() {
		return new ModelAndView("/singer/riyaz");
	}
	
	@RequestMapping(value = "/riyaz/index", method = RequestMethod.GET)
	public String riyazindex(ModelMap map) {
		return "/singer/riyaz";
	}
	
	@RequestMapping(value = "/singer/register", method = RequestMethod.GET)
	public ModelAndView register(HttpSession session) {
		//SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		Other otherData = (Other) session.getAttribute("Other");
		if (otherData != null)
			return new ModelAndView("/singer/index");
		else
			return new ModelAndView("/singer/register", "user", new Other());
	}

	@RequestMapping(value = "/singer/register-landing", method = RequestMethod.GET)
	public ModelAndView registerSuccess() {

		return new ModelAndView("/singer/register-landing");

	}

	@RequestMapping(value = "/singer/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		Other otherData = (Other) session.getAttribute("Other");
		if (userData != null || otherData != null)
			return new ModelAndView("/singer/index");
		else
			return new ModelAndView("/singer/login", "user", new Other());
	}
	
	@RequestMapping(value = "/singer/validateLogin", method = RequestMethod.GET)
	public ModelAndView validateLogin(HttpSession session) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		Other otherData = (Other) session.getAttribute("Other");
		if (userData != null || otherData != null)
			return new ModelAndView("/singer/index");
		else
			return new ModelAndView("/singer/login", "user", new SchoolUser());

	}

	@RequestMapping(value = "/singer/validateLogin", method = RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("user") SchoolUser user, //@ModelAttribute("user") Other other,
			BindingResult result, RedirectAttributes redirectAttributes,
			HttpSession session,
			@RequestParam(value = "next", required = false) String next) {
		// userValidator.validate(user, result);
			Other other = new Other();
		if (user.getUsername() != null && !user.getUsername().isEmpty()
				&& user.getPassword() != null && !user.getPassword().isEmpty()) {
			ModelAndView modelAndView = new ModelAndView();
			System.out.println("in submit" + user);
			String username = user.getUsername();
			String password = user.getPassword();
			SchoolUser userData = userService.validateUser(username, password);

			if (userData != null) {

				if (userData.getActive() == 1) {
					session.setAttribute("SchoolStudent", userData);
					if (next != null && !next.isEmpty())
						modelAndView.setViewName("redirect:" + next);
					else
						modelAndView.setViewName("redirect:/singer");
					return modelAndView;
				} else {
					modelAndView.getModel().put("AuthError",
							"Please activate your account before login");
					modelAndView.setViewName("/singer/login");
					return modelAndView;
				}
			} else {
				Other otherData = otherService.validateUser(username, password);
				
				  if (otherData != null) {
				  
				  if (otherData.getActive() == 1) { session.setAttribute("Other", otherData);
				  if (next != null && !next.isEmpty()) modelAndView.setViewName("redirect:" +
				  next); else modelAndView.setViewName("redirect:/singer"); return
				  modelAndView; } else { modelAndView.getModel().put("AuthError",
				  "Please activate your account before login");
				  modelAndView.setViewName("/singer/login"); return modelAndView; } }
				 
				modelAndView.getModel().put("AuthError",
						"Invalid UserName / Password");
				modelAndView.setViewName("/singer/login");
				return modelAndView;
			}
		} else {
			return new ModelAndView("/singer/login");
		}

	}

	@RequestMapping(value = "/singer/slogout", method = RequestMethod.GET)
	public ModelAndView slogout(HttpSession session) {

		session.removeAttribute("SchoolStudent");
		session.invalidate();
		return new ModelAndView("/singer/login", "user", new SchoolUser());
	}
	
	@RequestMapping(value = "/singer/ologout", method = RequestMethod.GET)
	public ModelAndView ologout(HttpSession session) {

		session.removeAttribute("Other");
		session.invalidate();
		return new ModelAndView("/singer/login", "user", new Other());
	}
	
	@RequestMapping(value = "/singer/doregister", method = RequestMethod.POST)
	public ModelAndView register(
			@ModelAttribute("user") @Validated({ SaveUser.class }) Other other,
			BindingResult result, HttpSession session) throws IOException {
		registerValidator.validate(other, result);
		if (!result.hasErrors()) {
			System.out.println("NO ERRORS");
			boolean isStudentSaved = otherService.saveOther(other);
			System.out.println("student saved");
			if (isStudentSaved) {
					return new ModelAndView(
							"redirect:/singer/register-landing?success=true");
			} else
				return new ModelAndView(
						"redirect:/singer/register-landing?success=false");
		} else {
			return new ModelAndView("/singer/register");
		}

	}
	
	@RequestMapping(value = "/singer/user/upload_singing/{id}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView singingSubmissionForm(
			@PathVariable("id") String id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Competition competition = competitionService
				.getCompetitionDetails(Integer.parseInt(id));
		if (competition != null) {
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
			Other otherData = (Other) session.getAttribute("Other");
			if(userData!=null) {
			Integer user_total_competition_submissions = competitionService
					.getStudentTotalMSTSubmissionsOfACompetition(
							userData.getUsername(),
							competition.getComp_id());
			if (user_total_competition_submissions >= 3)
				modelAndView.addObject("submissions_exceeded", true);
			else
				modelAndView.addObject("submissions_exceeded", false);
			} else if(otherData!=null) {
			
			  Integer user_total_competition_submissions = competitionService
			  .getStudentTotalMSTSubmissionsOfACompetition( otherData.getUsername(),
			  competition.getComp_id()); if (user_total_competition_submissions > 1)
			  modelAndView.addObject("submissions_exceeded", true);
			 
			}
			modelAndView.addObject("competition", competition);
			modelAndView.setViewName("/singer/upload_singing");
			return modelAndView;
		} else
			return new ModelAndView("redirect:/singer");
		//modelAndView.setViewName("/singer/upload_singing");
		//return modelAndView;

	}
	
	@RequestMapping(value = "/singer/user/submit-singing", method = RequestMethod.POST)
	public ModelAndView submitSinging(@ModelAttribute("mst") MSTCompetition mst,
			HttpSession session,
			@RequestParam(value = "mst_video", required = true) MultipartFile mst_video)
			throws IOException {
		
			SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
			Other otherData = (Other) session.getAttribute("Other");
			if(userData!=null) {
				mst.setUser_name(userData.getUsername());
	
				String filename = userData.getUsername() + "_"
						+ competitionService.getMstMaxID() + "."
						+ mst_video.getOriginalFilename().split("\\.")[1];
				mst.setSubmission_file_name(filename);
			Integer id = competitionService.saveMSTCompetition(mst);
			if (id != 0) {
				uploadFile(filename, mst_video, mst.getSubmission_type());
				userData.setPoints(userData.getPoints()+20);
				return new ModelAndView(
						"redirect:/singer/user/singing_saved?type="+mst.getSubmission_type()+"&success=true&id="
								+ id);
			} else
				return new ModelAndView(
						"redirect:/singer/user/singing_saved?type="+mst.getSubmission_type()+"&success=false");
			} else if(otherData!=null) {
				mst.setUser_name(userData.getUsername());

				String filename = userData.getUsername() + "_"
						+ competitionService.getMstMaxID() + "."
						+ mst_video.getOriginalFilename().split("\\.")[1];
				mst.setSubmission_file_name(filename);
				Integer id = competitionService.saveMSTCompetition(mst);
				if (id != 0) {
					uploadFile(filename, mst_video, mst.getSubmission_type());
					userData.setPoints(userData.getPoints()+20);
					return new ModelAndView(
							"redirect:/singer/user/singing_saved?type="+mst.getSubmission_type()+"&success=true&id="
									+ id);
				} else
					return new ModelAndView(
							"redirect:/singer/user/singing_saved?type="+mst.getSubmission_type()+"&success=false");
			}
			return new ModelAndView(
					"redirect:/singer/user/singing_saved?type="+mst.getSubmission_type()+"&success=false");

	}
	
	@RequestMapping(value = "/singer/user/singing_saved", method = RequestMethod.GET)
	public String wiytCompetitionSaved() {
		return "/singer/singing_saved";
	}
	
	private void uploadFile(String filename, MultipartFile image,
			String competition) {
		File image_path = new File(servletContext.getRealPath("/")
				+ "user_images/Comp_Sub/Singer/" + filename);
		image_path.getParentFile().mkdirs();
		try {
			FileUtils.writeByteArrayToFile(image_path, image.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/singer/view_singing/{id}", method = RequestMethod.GET)
	public ModelAndView mstCompetitionEntryView(
			@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		MSTCompetition entry = competitionService
				.getMSTCompetitionSubmission(Integer.parseInt(id));
		
		//SchoolUser entryuser = otherService.getStudentDetails(entry.getUser_name());
		//modelAndView.addObject("entryuser", entryuser);
		modelAndView.addObject("entry", entry);
		//String name = entryuser.getName();
		//modelAndView.addObject("name", name);
		competitionService.saveEntryVisit(entry.getId());
		
		int nextEntry=competitionService.getNextOrPreviousEntryId(entry.getId(), entry.getSubmission_type(), true, false);
		int previousEntry=competitionService.getNextOrPreviousEntryId(entry.getId(), entry.getSubmission_type(), false, true);	
		if(nextEntry!=0)
		modelAndView.addObject("nextEntry", nextEntry);
		if(previousEntry!=0)
		modelAndView.addObject("previousEntry", previousEntry);
		
		modelAndView.setViewName("/singer/view_singing");
		return modelAndView;

	}
	
	@ResponseBody
	@RequestMapping(value = "/singer/validate-user-like", method = RequestMethod.POST)
	public String validateUserLike(
			@ModelAttribute UserLikeValidation userLikeValidation,
			HttpSession session, @RequestParam("fb_login") String fbLogin) {
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		Other otherData = (Other) session.getAttribute("Other");
		
		if (userData != null) {
			userLikeValidation.setUsername(userData.getUsername());
			if (userService.isStudentLiked(userLikeValidation)) {
				return "already-voted";
			} else {
				//if(userLikeValidation.getOldLikes()==49){
					//String subject = "Congratulations you've got 50 Likes for your entry at MySuperBrain";
					//String entrytype = userLikeValidation.getComp_type();
					//String body = MsbUtil.buildEntryLikesMail(userLikeValidation.getEntry_username(), entrytype);
					//mailService.sendMail(subject, body, userLikeValidation.getEntry_username(), false, "MySuperBrain");					
				//}
				userLikeValidation.setLikeDate(MsbUtil.getCurrentDate());
				if (userService.saveStudentLike(userLikeValidation)) {
					userService.updateUserPoints(
							userLikeValidation.getEntry_username(), 2);
					updateSingerCompetitionPoints(userLikeValidation.getComp_type(),
							userLikeValidation.getEntry_id());
					return "voted";
				}
			}

		} else if (otherData != null) {
			userLikeValidation.setUsername(otherData.getUsername());
			if (otherService.isStudentLiked(userLikeValidation)) {
				return "already-voted";
			} else {
				//if(userLikeValidation.getOldLikes()==49){
					//String subject = "Congratulations you've got 50 Likes for your entry at MySuperBrain";
					//String entrytype = userLikeValidation.getComp_type();
					//String body = MsbUtil.buildEntryLikesMail(userLikeValidation.getEntry_username(), entrytype);
					//mailService.sendMail(subject, body, userLikeValidation.getEntry_username(), false, "MySuperBrain");					
				//}
				userLikeValidation.setLikeDate(MsbUtil.getCurrentDate());
				if (otherService.saveStudentLike(userLikeValidation)) {
					otherService.updateUserPoints(
							userLikeValidation.getEntry_username(), 2);
					updateSingerCompetitionPoints(userLikeValidation.getComp_type(),
							userLikeValidation.getEntry_id());
					return "voted";
				}
			}
		}else
			return "nouser";
		return null;

	}
	
	private boolean updateSingerCompetitionPoints(String comp_type, int id) {
		competitionService.updateMSTSubmissionPoints(id, 2);
		return true;
	}

}
