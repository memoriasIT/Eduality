package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {

    // PRIMARY KEYS
	@Id
	@GeneratedValue
	private int idComment;



	// OTHER
    @NotNull
    private String content;

     @ManyToOne
	private User user;


    @NotNull
    private boolean highlighted;


    // FOREIGN RELATIONS
    @OneToMany(mappedBy = "idReport")
	private List<Report> ReportList;

    @OneToMany (mappedBy = "idAward")
    private List<Award> awardList;
}
