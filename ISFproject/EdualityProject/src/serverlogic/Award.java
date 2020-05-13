package serverlogic;

public class Award {
    int type;
    //type 1=copper
    //type 2=silver
    //type 3=gold
    int awardValue;
    static int awardMultiplier=10;

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