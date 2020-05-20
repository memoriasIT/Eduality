package serverlogic;

public class User {
    String email;
    String name;
    String password;
    boolean expert;
    int goldAmount=0;
    int silverAmount=0;
    int copperAmount=0;

    public User(String e,String n,String p,boolean b) {
        email=e;
        name=n;
        password=p;
        expert=b;
    }
    
    // WE USED THIS CONSTRACTOR WITH THE VALUES ALREADY IN THE DATABASE SO THAT WE CAN HAVE A USER EXPERT WITH AWARDS
    // createUsersFromDatabase() should be created in the Database class 
    public User(String e,String n,String p,boolean b, int copper, int silver, int gold) {
        email=e;
        name=n;
        password=p;
        expert=b;
        goldAmount=gold;
        silverAmount=silver;
        copperAmount=copper;
    }

    public boolean isExpert() {
        return expert;
    }

    public int awardsAvaliable() {
        if(!expert) {
            System.out.println("User is not an expert");
            if(goldAmount>0 || silverAmount>0 || copperAmount>0) {
            	throw new RuntimeException("A normal user cannot have awards");
            }
            
            return goldAmount+silverAmount+copperAmount;
        }else {
            System.out.println("The user has "+goldAmount+" gold awards");
            System.out.println("The user has "+silverAmount+" gold awards");
            System.out.println("The user has "+copperAmount+" copper awards");
            int totalAwardsAmount=goldAmount+silverAmount+copperAmount;
            
            if(goldAmount<0 || silverAmount<0 || copperAmount<0) {
            	throw new RuntimeException("Total amount of awards cannot be negative");
            }
            
            return totalAwardsAmount;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void giveAwardContent(Content content,Award award) {
        if( isExpert() && content!=null && award!=null) {
        	award.applyAward(content);
        }
    }
    
    

}