package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


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
	private Integer upvotes;

	@NotNull
	private Date uploadDate;


	// FOREIGN RELATIONS
	@OneToMany (mappedBy = "idReport")
	private List<Report> reportList;

	@OneToMany (mappedBy = "idAward")
	private List<Award> awardList;


	// INTERNAL LOGIC
	private Integer partialVotes;
	private double reputation;

	private boolean hasAward;
	private Date date;


	public Content() {
		
		
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
	@Override
	public String toString() {
		return "Content [title=" + title + ", ]";
	}

}
