package es.uma.ingsoftware.eduality.model;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;
import es.uma.ingsoftware.eduality.model.Award;
import es.uma.ingsoftware.eduality.model.Content;

@Entity
public class User {


    // PRIMARY KEY
	@Id
    @NotNull
    @Column(unique = true)
	@GeneratedValue
	private Integer idUser;


    // OTHER
    private String name;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private boolean expert;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    private Integer goldamount;
    private Integer silveramount;
    private Integer copperamount;


    // FOREIGN RELATIONS
    @OneToMany (mappedBy = "idPost")
    private List<Post> postList;


    
    
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
