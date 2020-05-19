package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

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
        //content.updateReputation(awardValue);
        //content.addAward(this);
    }
    
}
