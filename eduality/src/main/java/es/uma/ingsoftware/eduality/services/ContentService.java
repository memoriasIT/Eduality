package es.uma.ingsoftware.eduality.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uma.ingsoftware.eduality.model.Content;
import es.uma.ingsoftware.eduality.repository.ContentRepository;

@Service
public class ContentService {
	
	@Autowired
	ContentRepository cr;
	
	public List<Content> getAll(){
		
		return cr.findAll();
	}
	
	

}
