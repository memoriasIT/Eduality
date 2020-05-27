package com.test.edualitytest.logic;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.edualitytest.services.ContentService;
import com.test.edualitytest.models.*;

public class ContentLogic {

	private double reputation;
	private int totalVotes;
	private int partialVotes;
	private String title;
	private String body;
	private String topic;
	private Date uploadDate;
	private int idContent;
	

	private int idUser;
	private boolean hasAward;
	private ArrayList<AwardLogic>listAwards;
	
	@Autowired
	private static ContentService cs;

	//TODO WE NEED TO TEST THAT WHEN WE CREATE A CONTENT WITH hasAward true then listAward.getNumberAwards must be > 0 | CREATE TEST
	
	public ContentLogic createContent(int idContent, String title, String body, String topic,int votes,long uploadDate,int idUser,boolean hasAward) {
		if(title.length()<=0 || title.length()>50) {
			throw new RuntimeException("Invalid title length");
		}else if(body.length()<=0 || body.length()>1000) {
			throw new RuntimeException("Invalid body length");
		}else if(topic.length()<=0 || topic.length()>20) {
			throw new RuntimeException("Invalid topic length");
		}
		
		return new ContentLogic(idContent, title, body, topic, votes, uploadDate,idUser,hasAward);
	}
	
	private ContentLogic(int idContent,String title, String body, String topic,int votes,long uploadDate,int idUser,boolean hasAward) {
		this.idContent=idContent;
		this.title=title;
		this.body=body;
		this.topic=topic;
		this.totalVotes=votes;
		partialVotes=0;
		
		///What it should be done when creating a new content for the first time
		//LocalDateTime now = LocalDateTime.now();
		/// uploadTime = now.getTime();
		
		this.uploadDate = new Date(uploadDate);  //dtf.format(now);
		this.idUser = idUser; 
		this.hasAward=hasAward;
		listAwards=new ArrayList<AwardLogic>();
	}
	
	
	public ContentLogic createContentDatabase(int idContent, String title, String body, String topic,int votes,long uploadDate,int idUser,boolean hasAward, ArrayList<AwardLogic> listAwards) {
		if(title.length()<=0 || title.length()>50) {
			throw new RuntimeException("Invalid title length");
		}else if(body.length()<=0 || body.length()>1000) {
			throw new RuntimeException("Invalid body length");
		}else if(topic.length()<=0 || topic.length()>20) {
			throw new RuntimeException("Invalid topic length");
		}
		
		return new ContentLogic(idContent, title, body, topic, votes, uploadDate,idUser,hasAward,listAwards);
	}
	
	
	public ContentLogic(int idContent,String title, String body, String topicName,int votes,long uploadDate,int idUser,boolean hasAward, ArrayList<AwardLogic> listAwards) {
		this.idContent=idContent;
		this.title=title;
		this.body=body;
		this.topic= topicName;
		this.totalVotes=votes;
		partialVotes=0;
		
		
		this.uploadDate = new Date(uploadDate);  
		this.idUser = idUser; 
		this.hasAward=hasAward;
		this.listAwards=listAwards;
	}
	
	
	
	
	
	public String getTopic() {
		return topic;
	}
	
	public void updateReputation(double value) {
		//TODO Checking the value doesn't have error
		reputation+=value;
	}

	public void resetPartialVotes() {
		partialVotes=0;
	}
	
	public int getTotalVotes() {
		return totalVotes;
	}
	
	public int getPartialVotes() {
		return partialVotes;
	}

	public void upvote() {		
		 
		totalVotes++;
		partialVotes++;
	}
	
	public void downvote() {
		if(totalVotes>0) {
			totalVotes--;
		}
		partialVotes--;
	}

	public boolean getHasAward() {
		return hasAward;
	}
	
	public void addAward(AwardLogic award) {
		listAwards.add(award);
	}
	
	public double getReputation() {
		
		return this.reputation;
	}
	
	public int getIdContent() {
		return idContent;
	}
	
	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Date getUploadDate() {
		return uploadDate;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public ArrayList<AwardLogic> getListAwards() {
		return listAwards;
	}

}
