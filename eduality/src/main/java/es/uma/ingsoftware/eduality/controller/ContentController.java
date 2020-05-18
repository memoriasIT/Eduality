package es.uma.ingsoftware.eduality.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uma.ingsoftware.eduality.model.Content;
import es.uma.ingsoftware.eduality.services.ContentService;

@Controller
public class ContentController {
	
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	
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

	/*
	@RequestMapping("content/add")
	public String addContent (@Valid @ModelAttribute("content")Content content, 
    BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
            return "error";
        }
		
		//Attributes that are not included on the form
        model.addAttribute("reputation", 0);
        model.addAttribute("totalVotes", 0);
        model.addAttribute("partialVotes", 0);
        model.addAttribute("uploadDate", formatter.format(new Date(System.currentTimeMillis())));
        model.addAttribute("hasAward", 0);
        model.addAttribute("listAwards", null);
        
        // Need to figure out how to do the User id 
		
		return "content/add";
	}
	*/
	
	@PostMapping("content/save")
	public String saveContent(Content c) {
		
		cs.save(c);
		
		return "redirect:/content";
	}
	
	
	@RequestMapping("content/edit/{id}")
	public String editContent(@PathVariable("idContent") Integer idContent, Model model) {
		
		model.addAttribute("content", cs.getById(idContent));
		
		return "content/add";
	}
	
	@RequestMapping("content/view/{id}")
	public String viewContent(@PathVariable("idContent") Integer idContent, Model model) {
		
		model.addAttribute("content", cs.getById(idContent));
		
		return "content/view";
	}
	
	
	@RequestMapping("content/delete/{id}")
	public String deleteContent(@PathVariable("idContent") Integer idContent) {
		
		cs.delete(idContent);
		
		return "redirect:/content";
	}
	

}
