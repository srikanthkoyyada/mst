package com.msb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msb.model.BlogArticle;
import com.msb.model.CompetitionText;
import com.msb.model.SchoolUser;
import com.msb.service.ArticleService;

@Controller
public class BlogArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/srichaitanya/submit-article", method = RequestMethod.POST)
	public ModelAndView submitArticle(@ModelAttribute("article") BlogArticle article,
			HttpSession session, BindingResult result) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		ModelAndView modelAndView = new ModelAndView();
		int isUserPremium = userData.getPremium();
		if(isUserPremium==1) {
			modelAndView.addObject("isPremium", true);
		} else {
			modelAndView.addObject("isPremium", false);
		}
		article.setUser_saved(userData.getUsername());
		//article.setShr_code(generateArticleShareCode());
		boolean saved = articleService.saveArtcile(article);
		if (saved)
			return new ModelAndView("redirect:/srichaitanya/user/write-article?success=true");
		else
			return new ModelAndView("redirect:/srichaitanya/user/write-article?success=false");

	}

	@RequestMapping(value="/srichaitanya/premium/articles/{category}/{offset}",method=RequestMethod.GET)
	public ModelAndView showArticles(@PathVariable String category, @PathVariable int offset, HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
		}
		int totalArticlesCount = articleService.getBlogArticlesCount(category);
		modelAndView.addObject("totalArticlesCount", totalArticlesCount);
		System.out.println("totalArticlesCount"+totalArticlesCount);
		List<BlogArticle> articles=articleService.getBlogArtciles(category, 10, offset);
		modelAndView.addObject("articles", articles);
		List<BlogArticle> recentArticles=articleService.getRecentBlogArtciles(5);
		modelAndView.addObject("recentArticles", recentArticles);
		List<String> categories=articleService.getBlogArticleCategoryList();
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("category", category);
		modelAndView.setViewName("/srichaitanya/premium/articles-list");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/srichaitanya/premium/article/{id}",method=RequestMethod.GET)
	public ModelAndView showFullArticle(@PathVariable int id, HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
		}
		BlogArticle article=articleService.getBlogArticle(id);
		modelAndView.addObject("article", article);
		modelAndView.setViewName("/srichaitanya/premium/article");
		List<BlogArticle> recentArticles=articleService.getRecentBlogArtciles(5);
		modelAndView.addObject("recentArticles", recentArticles);
		List<String> categories=articleService.getBlogArticleCategoryList();
		modelAndView.addObject("categories", categories);
		int nextArticle=articleService.getNextOrPreviousBlogArticleCode(article.getArticle_category(),article.getArticle_id(), true, false);
		int previousArticle=articleService.getNextOrPreviousBlogArticleCode(article.getArticle_category(),article.getArticle_id(), false, true);	
		if(nextArticle!=0)
		modelAndView.addObject("nextArticle", nextArticle);
		if(previousArticle!=0)
		modelAndView.addObject("previousArticle", previousArticle);
		modelAndView.setViewName("/srichaitanya/premium/article");
		return modelAndView;
	}
	
	
	/* blog controllers for school section  starts ----*/
	
	@RequestMapping(value = "/school/submit-article", method = RequestMethod.POST)
	public ModelAndView submitSchoolArticle(@ModelAttribute("article") BlogArticle article,
			HttpSession session, BindingResult result) {

		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		ModelAndView modelAndView = new ModelAndView();
		int isUserPremium = userData.getPremium();
		if(isUserPremium==1) {
			modelAndView.addObject("isPremium", true);
		} else {
			modelAndView.addObject("isPremium", false);
		}
		article.setUser_saved(userData.getUsername());
		//article.setShr_code(generateArticleShareCode());
		boolean saved = articleService.saveArtcile(article);
		if (saved)
			return new ModelAndView("redirect:/school/user/write-article?success=true");
		else
			return new ModelAndView("redirect:/school/user/write-article?success=false");

	}

	@RequestMapping(value="/school/premium/articles/{category}/{offset}",method=RequestMethod.GET)
	public ModelAndView showSchoolArticles(@PathVariable String category, @PathVariable int offset, HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
		}
		int totalArticlesCount = articleService.getBlogArticlesCount(category);
		modelAndView.addObject("totalArticlesCount", totalArticlesCount);
		System.out.println("totalArticlesCount"+totalArticlesCount);
		List<BlogArticle> articles=articleService.getBlogArtciles(category, 10, offset);
		modelAndView.addObject("articles", articles);
		List<BlogArticle> recentArticles=articleService.getRecentBlogArtciles(5);
		modelAndView.addObject("recentArticles", recentArticles);
		List<String> categories=articleService.getBlogArticleCategoryList();
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("category", category);
		modelAndView.setViewName("/school/premium/articles-list");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/school/premium/article/{id}",method=RequestMethod.GET)
	public ModelAndView showSchoolFullArticle(@PathVariable int id, HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		SchoolUser userData = (SchoolUser) session.getAttribute("SchoolStudent");
		if (userData != null) {
			
			int isUserPremium = userData.getPremium();
			if(isUserPremium==1) {
				modelAndView.addObject("isPremium", true);
			} else {
				modelAndView.addObject("isPremium", false);
			}
		}
		BlogArticle article=articleService.getBlogArticle(id);
		modelAndView.addObject("article", article);
		modelAndView.setViewName("/school/premium/article");
		List<BlogArticle> recentArticles=articleService.getRecentBlogArtciles(5);
		modelAndView.addObject("recentArticles", recentArticles);
		List<String> categories=articleService.getBlogArticleCategoryList();
		modelAndView.addObject("categories", categories);
		int nextArticle=articleService.getNextOrPreviousBlogArticleCode(article.getArticle_category(),article.getArticle_id(), true, false);
		int previousArticle=articleService.getNextOrPreviousBlogArticleCode(article.getArticle_category(),article.getArticle_id(), false, true);	
		if(nextArticle!=0)
		modelAndView.addObject("nextArticle", nextArticle);
		if(previousArticle!=0)
		modelAndView.addObject("previousArticle", previousArticle);
		modelAndView.setViewName("/school/premium/article");
		return modelAndView;
	}

}
