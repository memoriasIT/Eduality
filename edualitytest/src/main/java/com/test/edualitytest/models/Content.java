package com.test.edualitytest.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;
import com.test.edualitytest.logic.AwardLogic;
import com.test.edualitytest.logic.ContentLogic;


@Entity
public class Content {

	
	// PRIMARY KEY
		@Id
		@GeneratedValue
		private Integer contentId;

		@ManyToOne
		private User user;

		@ManyToOne
		private Topic topic;


		// OTHER
		@NotNull
		private String title;

		private String body;

		@NotNull
		private Integer upvotes; //upvotes is the same than totalVotes in the old model
		
		private Integer partialVotes;
		
		@NotNull
		private Double reputation;
		
		@NotNull
		private Date uploadDate;


		// FOREIGN RELATIONS
		@OneToMany (mappedBy = "idReport")
		private List<Report> reportList;

		@OneToMany (mappedBy = "idAward")
		private List<Award> awardList;


		// INTERNAL LOGIC
	
		private boolean hasAward;
	
	public Content() {
		
		
	}
		
	public Content(ContentLogic myContent) {
		
		//Do we need to get the Id also???
		//this.contentId=myContent.getIdContent();
		this.title= myContent.getTitle();
		this.body= myContent.getBody();
		this.topic= new Topic (myContent.getTopic()) ;
		this.upvotes= myContent.getTotalVotes() ;
		
		//we don't really need to have partial votes in the database
		//partialVotes= myContent.getPartialVotes() ;
		
		
		
		
		this.uploadDate = myContent.getUploadDate(); 
		this.user = new User(myContent.getIdUser()); 
		this.hasAward=myContent.getHasAward();
		
		awardList=convertListOfAwardLogic(myContent.getListAwards());
		
		
	}
	
	private List<Award> convertListOfAwardLogic(List<AwardLogic> myListOfAwardLogic){
		List<Award> myListOfAwards = new ArrayList<>();
		
		for(AwardLogic award : myListOfAwardLogic) {
			myListOfAwards.add(new Award(award));
		}
		
		return myListOfAwards;
	}
	
	public Integer getUpvotes() {
		return upvotes;
	}


	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getPartialVotes() {
		return partialVotes;
	}


	public void setPartialVotes(Integer partialVotes) {
		this.partialVotes = partialVotes;
	}


	public double getReputation() {
		return reputation;
	}


	public void setReputation(double reputation) {
		this.reputation = reputation;
	}


	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public boolean isHasAward() {
		return hasAward;
	}

	public void setHasAward(boolean hasAward) {
		this.hasAward = hasAward;
	}

	public void upvote() {
		
		this.upvotes ++;
		
	}
	@Override
	public String toString() {
		return "Content [title=" + title + ", topic=" + topic + ", user=" + user + "]";
	}
	

}
