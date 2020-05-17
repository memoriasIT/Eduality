package es.uma.ingsoftware.eduality.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.uma.ingsoftware.eduality.model.Award;
import es.uma.ingsoftware.eduality.model.Content;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int idUser;
	
	
    private String email;
    private String name;
    private String password;
    private boolean expert;
    private int goldamount;
    private int silveramount;
    private int copperamount;
    
    @OneToMany (mappedBy = "user")
    private List<Content> contentList;
    
    
    public User() {}
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
            System.out.println("The user has "+goldamount+" gold awards");
            System.out.println("The user has "+silveramount+" gold awards");
            System.out.println("The user has "+copperamount+" copper awards");
        }
    }

    public String getemail() {
        return email;
    }

    public String getname() {
        return name;
    }

    public void giveAward(Content content,Award award) {
        if( isExpert() && content!=null && award!=null) {
        	award.applyAward(content);
        }
    }

}
