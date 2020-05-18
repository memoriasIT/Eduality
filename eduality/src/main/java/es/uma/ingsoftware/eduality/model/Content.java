package es.uma.ingsoftware.eduality.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
public class Content {


	// PRIMARY KEY
	@Id
	@NotNull
	@GeneratedValue
	private Integer idContent;

	@Id
	@NotNull
	@OneToOne
	private Integer idPost;

	@Id
	@NotNull
	@ManyToOne
	private Integer idUser;

	@Id
	@NotNull
	@ManyToOne
	private Integer idTopic;


	// OTHER
	@NotNull
	private String title;

	private String body;

	@NotNull
	private Integer upvotes;

	@NotNull
	private Date uploadTime;
	

	// FOREIGN RELATIONS
	@OneToMany (mappedBy = "Report")
	private List<Report> reportList;

	@OneToMany (mappedBy = "idAward")
    private List<Award> awardList;


	// INTERNAL LOGIC
	private Integer partialVotes;
	private double reputation;

	private boolean hasAward;
	private Date date;
	
	private ArrayList<Award>listAwards;

	public Content()
	{
		
	}
	
	public Content(String title, String body)
	{
		this.title = title;
		this.body = body;
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
		return upvotes;
	}
	public void setTotalVotes(Integer totalVotes) {
		this.upvotes = totalVotes;
	}
	public int getPartialVotes() {
		return partialVotes;
	}
	public void setPartialVotes(Integer partialVotes) {
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
	public int getTopic() {
		return idTopic;
	}
	public void setTopic(int topic) {
		this.idTopic = topic;
	}
	public Date getUploadDate() {
		return uploadTime;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadTime = uploadDate;
	}
	public int getIdContent() {
		return idContent;
	}
	public void setIdContent(Integer idContent) {
		this.idContent = idContent;
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
		upvotes++;
		partialVotes++;
	}
	
	public void downvote() {
		if(upvotes>0) {
			upvotes--;
		}
		partialVotes--;
	}
	

}
