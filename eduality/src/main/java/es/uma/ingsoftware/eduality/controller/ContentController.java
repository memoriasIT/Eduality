package es.uma.ingsoftware.eduality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uma.ingsoftware.eduality.model.Content;
import es.uma.ingsoftware.eduality.services.ContentService;

@Controller
public class ContentController {
	
	@Autowired
	ContentService cs;              
	
	@RequestMapping("content")
	public String contentList(Model model) {
		
		List<Content> content = cs.getAll();
		
//		Content c1 = new Content("A","Andalucia");
//		Content c2 = new Content("B","Banana");
//		Content c3 = new Content("C","Codicia");
//		Content c4 = new Content("D","Diciembre");
//		
//		content.add(c1);
//		content.add(c2);
//		content.add(c3);
//		content.add(c4);
		
		
		
		model.addAttribute("contentList", content);
		
		return "content/index";
	}
	
	@RequestMapping("content/add")
	public String addContent(Model model) {
		
		return "content/add";
	}
	
	@RequestMapping("content/edit/{id}")
	public String editContent(Model model) {
		
		//Method for searching by id
		
		return "content/edit";
	}
	
	@RequestMapping("content/delete/{id}")
	public String deleteContent() {
		
		return "redirect:/content";
	}
	

}
