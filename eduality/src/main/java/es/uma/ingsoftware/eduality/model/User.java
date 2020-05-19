package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.*;


@Entity
public class User {
	
	/*@Id
	@GeneratedValue
	private Integer idUser;
	
	
    private String email;
    private String name;
    private String password;
    
    @OneToMany (mappedBy = "user")
    private List<Content> contentList;*/

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


	// FOREIGN RELATIONS
	@OneToMany (mappedBy = "contentId")
	private List<Content> contentList;

	//@OneToMany (mappedBy = "idComment")
	//private List<Comment> commentList;
    
    public User() {}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
