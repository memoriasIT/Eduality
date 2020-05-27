package com.test.edualitytest.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Award { 
	    
	 // PRIMARY KEY
		@Id
		@GeneratedValue
		private Integer idAward;


		// OTHER
	    @NotNull
	    private Date dateAchieved;
	    private String description;

	    //type 1=copper; type 2=silver; type 3=gold
	    private Integer type;

	    // FOREIGN RELATIONS
	    @ManyToOne
	    private Content awardedContent;

	    @ManyToOne
	    private Comment awardedComment;


	    // INTERNAL LOGIC
	    private Integer awardValue;
	    private static Integer awardMultiplier=10;
	    
	    
	    public Award() {}

		public Integer getIdAward() {
			return idAward;
		}

		public void setIdAward(Integer idAward) {
			this.idAward = idAward;
		}

		public Date getDateAchieved() {
			return dateAchieved;
		}

		public void setDateAchieved(Date dateAchieved) {
			this.dateAchieved = dateAchieved;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Content getAwardedContent() {
			return awardedContent;
		}

		public void setAwardedContent(Content awardedContent) {
			this.awardedContent = awardedContent;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public Integer getAwardValue() {
			return awardValue;
		}

		public void setAwardValue(Integer awardValue) {
			this.awardValue = awardValue;
		}
	    
	    

}
