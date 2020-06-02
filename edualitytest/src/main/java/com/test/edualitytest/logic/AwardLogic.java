package com.test.edualitytest.logic;

import java.util.ArrayList;
import java.util.List;

import com.test.edualitytest.models.Award;

public class AwardLogic {
    int type;
    //type 1=copper
    //type 2=silver
    //type 3=gold
    int awardValue;
    static int awardMultiplier=10;

    public AwardLogic(int t) {
        type=t;
        awardValue=awardMultiplier*type;
    }
    
    public AwardLogic(Award myAward) {
    	type = myAward.getType();
    	awardValue = myAward.getAwardValue(); 
    }
    
    public static List<AwardLogic> convertListOfAward(List<Award> myListOfAwardLogic){
		List<AwardLogic> myListOfAwardsLogic = new ArrayList<>();
		
		for(Award award : myListOfAwardLogic) {
			myListOfAwardsLogic.add(new AwardLogic(award));
		}
		
		return myListOfAwardsLogic;
	}

    public int getAwardValue() {
        return awardValue;
    }

    public int getType() {
        return type;
    }

    public void applyAward(ContentLogic content) {
        content.updateReputation(awardValue);
        content.addAward(this);
    }

}