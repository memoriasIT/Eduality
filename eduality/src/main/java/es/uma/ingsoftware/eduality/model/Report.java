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

    @NotNull
    private Integer idPost;


    // OTHER


    // FOREIGN RELATIONS
    @OneToMany(mappedBy = "issueId")
    private List<Issue> issueList;

    @ManyToOne
    private Content content;

    @ManyToOne
    private Comment comment;


    // Logic
}
