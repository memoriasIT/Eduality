package com.test.edualitytest.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.edualitytest.models.Content;
import com.test.edualitytest.services.ContentService;

public class EdualityLogic {
	
	private final double partialMultiplier = 0.7;
	private final double totalMultiplier = 0.3;
	private final double subtopicMultiplier = 1.25; 
	//private final double awardMultiplier = 1.75; 
	
	@Autowired
	ContentService cs;
	
	
	 public void fairAlgorithm(ContentLogic content){
		 
		 //I NEED TO USE AGAIN THE METHODS OF ContentLogic(like at the start)
		
		 double value=0;
			
			//We take into account different things:
			
			//We value more partial votes than total votes 
			value= content.getPartialVotes()*partialMultiplier + content.getTotalVotes()*totalMultiplier;
			
			if(!content.getTopic().equalsIgnoreCase("all")) {
				value=value*subtopicMultiplier;
			}
				
			//Everytime that we get a new award the value is also updated but it shouldn't
			//be done here because it is only applied when we get a new Award for a content
			//and not every 60 min (which is the period that this fairAlgorithm executes)
			
			content.updateReputation(value);
			content.resetPartialVotes();
		
		Content myContent = new Content(content);
		
		cs.save(myContent);
		
	}
	
	
}
