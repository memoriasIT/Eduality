package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Issue {

	// PRIMARY KEY
	@Id
	@GeneratedValue
	private Integer issueId;

    @NotNull
    private Integer idPost;


	// OTHER
	private String reason;

	// FOREIGN RELATIONS
	@ManyToOne
 	private Report report;

}
