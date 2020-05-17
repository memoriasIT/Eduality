package es.uma.ingsoftware.eduality.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.uma.ingsoftware.eduality.model.Award;

@Entity
public class Content {
	
	private double reputation;
	private int totalVotes;
	private int partialVotes;
	private String title;
	private String body;
	private String topic;
	private long uploadDate;
	
	
	@Id
	@GeneratedValue
	private int idContent;
	
	
	private int idUser;
	private boolean hasAward;
	private Date date;
	
	
	

	//private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	private ArrayList<Award>listAwards;
	
	public Content()
	{
		
	}
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public double getReputation() {
		return reputation;
	}
	public void setReputation(double reputation) {
		this.reputation = reputation;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	public int getPartialVotes() {
		return partialVotes;
	}
	public void setPartialVotes(int partialVotes) {
		this.partialVotes = partialVotes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public long getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(long uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getIdContent() {
		return idContent;
	}
	public void setIdContent(int idContent) {
		this.idContent = idContent;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public boolean isHasAward() {
		return hasAward;
	}
	public void setHasAward(boolean hasAward) {
		this.hasAward = hasAward;
	}
//	public DateTimeFormatter getDtf() {
//		return dtf;
//	}
//	
//    public void setDtf(DateTimeFormatter dtf) {
//		this.dtf = dtf;
//	}
//	
	
	
	public void addAward(Award award) {
		listAwards.add(award);
	}
	
	public void updateReputation(double value) {
		//TODO Checking the value doesn't have error
		reputation+=value;
	}
	
	public void resetPartialVotes() {
		partialVotes=0;
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
	

}