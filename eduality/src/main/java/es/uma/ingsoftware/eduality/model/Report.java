package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Report {

    // PRIMARY KEY
	@Id
    @NotNull
	@GeneratedValue
	private Integer idReport;

    @Id
    @NotNull
    private Integer idPost;


    // OTHER


    // FOREIGN RELATIONS
    @OneToMany(mappedBy = "Issue")
    private List<Issue> IssueList;

    @ManyToOne
    private int contentId;

    @ManyToOne
    private int commentId;
}
