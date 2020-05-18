package es.uma.ingsoftware.eduality.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.uma.ingsoftware.eduality.model.Content;

@Entity
public class Award {
	
	@Id
	@GeneratedValue
	private Integer idAward;
    private Integer type;
    
    //type 1=copper
    //type 2=silver
    //type 3=gold
    private Integer awardValue;
    private Date dateAchieved;
    private String description;
    private static Integer awardMultiplier=10;
    
    public Award() {}
    public Award(Integer t) {
        type=t;
        awardValue=awardMultiplier*type;
    }

    public int getAwardValue() {
        return awardValue;
    }

    public int getType() {
        return type;
    }

    public void applyAward(Content content) {
        content.updateReputation(awardValue);
        content.addAward(this);
    }
    
}
