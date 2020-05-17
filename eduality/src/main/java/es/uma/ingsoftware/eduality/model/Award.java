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
	private int idAward;
    private int type;
    
    //type 1=copper
    //type 2=silver
    //type 3=gold
    private int awardValue;
    private Date dateAchieved;
    private String description;
    private static int awardMultiplier=10;
    
    public Award() {}
    public Award(int t) {
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
