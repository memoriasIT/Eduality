package serverlogic;

public class User {
    String email;
    String name;
    String password;
    boolean expert;
    int goldAmount;
    int silverAmount;
    int copperAmount;

    public User(String e,String n,String p,boolean b) {
        email=e;
        name=n;
        password=p;
        expert=b;
    }

    public boolean isExpert() {
        return expert;
    }

    public void awardsAvaliable() {
        if(expert=false) {
            System.out.println("User is not an expert");
        }else {
            System.out.println("The user has "+goldAmount+" gold awards");
            System.out.println("The user has "+silverAmount+" gold awards");
            System.out.println("The user has "+copperAmount+" copper awards");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void giveAward(Content content,Award award) {
        if( isExpert() && content!=null && award!=null) {
        	award.applyAward(content);
        }
    }

}