package es.uma.ingsoftware.eduality.model;

import javax.persistence.*;

@Entity
public class Issue {

	// PRIMARY KEY
	@Id
	@GeneratedValue
	private int reportId;

	// OTHER

	// FOREIGN RELATIONS
	@ManyToOne
    private String reason;
}
