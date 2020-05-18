package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

	// PRIMARY KEY
	@Id
	@NotNull
	@ManyToOne // User -> PostList
	@OneToOne (mappedBy = "idPost") // Content -> idPost || Comment -> idPost
	@GeneratedValue
	private int idPost;

	@Id
	@NotNull
	@OneToMany (mappedBy = "idUser") // Content -> idUser
	private int idUser;


	// FOREIGN KEYS
	@OneToMany (mappedBy = "Comment")
	private List<Comment> CommentList;






}
