package com.test.edualitytest.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;



@Entity
public class Content {
	
	@Id
	@GeneratedValue
	private Integer contentId;
	
	private String title;
	private String topic;
	private String body;
	private Date uploadDate;
	@NotNull
	private Integer upvotes;
	
	@ManyToOne
	private User user;
	
	@OneToMany (mappedBy = "idAward")
	private List<Award> awardList;
	
	// INTERNAL LOGIC
	private Integer partialVotes;
	private double reputation;

	
	
	public Content() {
		
		
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
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
	
	public void upvote() {
		
		this.upvotes ++;
	}
	@Override
	public String toString() {
		return "Content [title=" + title + ", topic=" + topic + ", user=" + user + "]";
	}
	

}
