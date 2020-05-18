package es.uma.ingsoftware.eduality.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;
import es.uma.ingsoftware.eduality.model.Content;

@Entity
public class Award {


    // PRIMARY KEY
	@Id
	@GeneratedValue
    @ManyToOne
	private Integer idAward;

	@Id
    //type 1=copper; type 2=silver; type 3=gold
    private Integer type;


	// OTHER
    @NotNull
    private Date dateAchieved;
    private String description;


    // FOREIGN RELATIONS


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
        content.updateReputation(awardValue);
        content.addAward(this);
    }
    
}
