package com.msb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.UploadATalent;
import com.msb.model.Other;
import com.msb.service.CompetitionService;
import com.msb.service.MailService;
import com.msb.service.OtherService;

@Controller
public class OthersEntryViewController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	CompetitionService competitionService;
	
	@Autowired
	OtherService otherService;
	
	@Autowired
	MailService mailService;

	
	@RequestMapping(value = "/others/view/text_competition/{id}", method = RequestMethod.GET)
	public ModelAndView textCompetitionEntryView(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		CompetitionText competitionText = competitionService
				.getTextCompetitionSubmission(Integer.parseInt(id));
		//List<EntryComments> comments=competitionService.getEntryComments(Integer.parseInt(id), "TEXT");
		modelAndView.addObject("entry", competitionText);
		//modelAndView.addObject("comments", comments);
		
		Other entryuser = otherService.getStudentDetails(competitionText.getUser_name());
		modelAndView.addObject("entryuser", entryuser);
		
		int nextEntry=competitionService.getNextOrPreviousTextId(competitionText.getId(), true, false);
		int previousEntry=competitionService.getNextOrPreviousTextId(competitionText.getId(), false, true);	
		if(nextEntry!=0)
		modelAndView.addObject("nextEntry", nextEntry);
		if(previousEntry!=0)
		modelAndView.addObject("previousEntry", previousEntry);
		competitionService.saveTextEntryVisit(competitionText.getId());
		if(competitionText.getVisits()==99){
			//String subject = "Congratulations you've got 100 views for your entry at MySuperBrain";
			//String entrytype = "Text";
			//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_textentry/"+id;
			//String body = MsbUtil.buildEntryViewsMail(entryuser.getUsername(), entrytype, link, Integer.parseInt(id));
			//mailService.sendMail(subject, body, entryuser.getMail(), false, "MySuperBrain");
		}
		
		modelAndView.setViewName("/others/entries/view_text_competition");
		return modelAndView;

	}

	@RequestMapping(value = "/others/view/mst_competition/{id}", method = RequestMethod.GET)
	public ModelAndView mstCompetitionEntryView(
			@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView();
		MSTCompetition entry = competitionService
				.getMSTCompetitionSubmission(Integer.parseInt(id));
		
		Other entryuser = otherService.getStudentDetails(entry.getUser_name());
		modelAndView.addObject("entryuser", entryuser);
		modelAndView.addObject("entry", entry);
		competitionService.saveEntryVisit(entry.getId());
		if(entry.getVisits()==99){
			//String subject = "Congratulations you've got 100 views for your entry at MySuperBrain";
			//String entrytype = "Music";
			//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_music/"+id;
			//String body = MsbUtil.buildEntryViewsMail(entryuser.getUsername(), entrytype, link, Integer.parseInt(id));
			//mailService.sendMail(subject, body, entryuser.getMail(), false, "MySuperBrain");
		}
		
		int nextEntry=competitionService.getNextOrPreviousEntryId(entry.getId(), entry.getSubmission_type(), true, false);
		int previousEntry=competitionService.getNextOrPreviousEntryId(entry.getId(), entry.getSubmission_type(), false, true);	
		if(nextEntry!=0)
		modelAndView.addObject("nextEntry", nextEntry);
		if(previousEntry!=0)
		modelAndView.addObject("previousEntry", previousEntry);
		competitionService.saveEntryVisit(entry.getId());
		
		modelAndView.setViewName("/others/entries/view_mst_competition");
		return modelAndView;

	}

	@RequestMapping(value = "/others/view/uat_competition/{id}", method = RequestMethod.GET)
	public ModelAndView uatCompetitionEntryView(@PathVariable("id") String id) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		UploadATalent uat = competitionService
				.getUploadATalentSubmission(Integer.parseInt(id));
		//List<EntryComments> comments=competitionService.getEntryComments(Integer.parseInt(id), "WIYT");
		String wordDocPath = null;
		String entryTextString=null;
		//if (uat.getEntry_type().equals("text")) {
			//wordDocPath = servletContext.getRealPath("/")
					//+ "user_images/Comp_Sub/UAT/" + uat.getEntry_file_name();
			//entryTextString=MsbUtil.readWordDocument(wordDocPath,uat.getEntry_file_name());
		//}
		
		modelAndView.addObject("textEntryContent", entryTextString);
		modelAndView.addObject("uat", uat);
		//modelAndView.addObject("comments", comments);
		Other entryuser = otherService.getStudentDetails(uat.getUser_name());
		modelAndView.addObject("entryuser", entryuser);		

		int nextEntry=competitionService.getNextOrPreviousUatId(uat.getId(), true, false);
		int previousEntry=competitionService.getNextOrPreviousUatId(uat.getId(), false, true);
		if(nextEntry!=0)
		modelAndView.addObject("nextEntry", nextEntry);
		if(previousEntry!=0)
		modelAndView.addObject("previousEntry", previousEntry);
		competitionService.saveUatEntryVisit(uat.getId());
		if(uat.getVisits()==99){
			//String subject = "Congratulations you've got 100 views for your entry at MySuperBrain";
			//String entrytype = "What is your talent";
			//String link = "https://mysuperbrain.in/view/mysuperbrain/competition_wiyt/"+id;
			//String body = MsbUtil.buildEntryViewsMail(entryuser.getUsername(), entrytype, link, Integer.parseInt(id));
			//mailService.sendMail(subject, body, entryuser.getMail(), false, "MySuperBrain");
		}
		
		modelAndView.setViewName("/others/entries/view_uat_competition");
		return modelAndView;

	}
	
	@RequestMapping(value = "/others/text_entries/{type}/{limit}/{offset}", method = RequestMethod.GET)
	public ModelAndView texttEntries(@PathVariable String type, @PathVariable int limit, 
			@PathVariable int offset) {
		ModelAndView modelAndView = new ModelAndView();
		int userCateory = 3;

		List<CompetitionText> entries = competitionService.getAllTextEntries(
				type, userCateory, limit, offset);

			modelAndView.addObject("entries", entries);
			modelAndView.addObject("type", type);
			modelAndView.addObject("limit", limit);
			modelAndView.addObject("offset", offset);
		
		modelAndView.setViewName("/others/entries/text_entries");
		return modelAndView;
	}
	
	@RequestMapping(value = "/others/mst_entries/{type}/{limit}/{offset}", method = RequestMethod.GET)
	public ModelAndView mstEntries(@PathVariable String type, @PathVariable int limit, 
			@PathVariable int offset) {
		ModelAndView modelAndView = new ModelAndView();
		int userCateory = 3;

		List<MSTCompetition> entries = competitionService.getAllMSTEntries(
				type, userCateory, limit, offset);

			modelAndView.addObject("entries", entries);
			modelAndView.addObject("type", type);
			modelAndView.addObject("limit", limit);
			modelAndView.addObject("offset", offset);
		
		modelAndView.setViewName("/others/entries/mst_entries");
		return modelAndView;
	}
	
	@RequestMapping(value = "/others/uat_entries/{limit}/{offset}", method = RequestMethod.GET)
	public ModelAndView texttEntries(@PathVariable int limit, 
			@PathVariable int offset) {
		ModelAndView modelAndView = new ModelAndView();
		int userCateory = 3;

		List<UploadATalent> entries = competitionService.getAllUATEntries(userCateory,
				limit, offset);

			modelAndView.addObject("entries", entries);
			modelAndView.addObject("limit", limit);
			modelAndView.addObject("offset", offset);
		
		modelAndView.setViewName("/others/entries/uat_entries");
		return modelAndView;
	}

}
