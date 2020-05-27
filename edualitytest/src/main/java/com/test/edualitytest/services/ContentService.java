package com.test.edualitytest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.edualitytest.models.Content;
import com.test.edualitytest.repositories.ContentRepository;


@Service
public class ContentService {
	
	@Autowired
	ContentRepository cr;
	
	public List<Content> getAll(){
		
		return cr.findAll();
	}

	public void save(Content c) {
		
		cr.saveAndFlush(c);
		
	}

	public void delete(Integer contentId) {
		
		cr.deleteById(contentId);
		
	}

	public Content getById(Integer contentId) {
		
		return cr.getOne(contentId);
	}

}
