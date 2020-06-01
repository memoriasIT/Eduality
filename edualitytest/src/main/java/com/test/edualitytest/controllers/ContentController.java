package com.test.edualitytest.controllers;

import java.sql.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.test.edualitytest.models.Content;
import com.test.edualitytest.models.Topic;
import com.test.edualitytest.services.ContentService;



@Controller
public class ContentController {
	
	@Autowired
	ContentService cs;
	
	@RequestMapping("home")
	public String contentList() {
		
				
		
		
		return "content/home";
	}
	
	@RequestMapping("content")
	public String contentList(Model model) {
		
		List<Content> contents = cs.getAll();
		
		model.addAttribute("contentList", contents);		
		
		
		
		return "content/index";
	}
	

	@RequestMapping("content/add")
	public String addContent (Model model) {
		
		model.addAttribute("content", new Content());	
		
		return "content/add";
	}
	
	@RequestMapping("content/edit/{contentId}")
	public String editContent(@PathVariable("contentId") Integer contentId, Model model) {
		
		model.addAttribute("content", cs.getById(contentId));
		
		return "content/add";
	}
	

	@RequestMapping("content/delete/{contentId}")
	public String deleteContent(@PathVariable("contentId") Integer contentId) {
		
		cs.delete(contentId);
		
		return "redirect:/content";
	}
	
	@PostMapping("content/save")
	public String saveContent(Content c) {
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		c.setPartialVotes(0);
		c.setReputation(0);
		c.setUpvotes(0);
		c.setUploadDate(ts);
		c.setTopic(new Topic());
		c.getTopic().setIdTopic(0);
		c.setHasAward(false);
		cs.save(c);
		
		return "redirect:/content";
	}
	
	@RequestMapping("content/view/{contentId}")
	public String viewContent(@PathVariable("contentId") Integer contentId, Model model) {
		
		model.addAttribute("content", cs.getById(contentId));
		
		return "content/view";
	}
	
	@RequestMapping("content/upvote/{contentId}")
	public String upVoteContent(@PathVariable("contentId") Integer contentId, Model model) {
		
		
	    cs.getById(contentId).upvote();
	    cs.save(cs.getById(contentId));
	    model.addAttribute("content", cs.getById(contentId));
		
		return "content/view";
	}
	
	

}
