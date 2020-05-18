package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {

    // PRIMARY KEYS
	@Id
	@GeneratedValue
    @ManyToOne
	private int idComment;

	@Id
	@NotNull
	@OneToOne
	private Integer idPost;

	@Id
	@NotNull
	@ManyToOne
	private Integer idUser;

	// OTHER
    @NotNull
    private String content;

    @NotNull
    private boolean highlighted;


    // FOREIGN RELATIONS
    @OneToMany(mappedBy = "Report")
	private List<Report> ReportList;

    @OneToMany (mappedBy = "idAward")
    private List<Award> awardList;
}
