package es.uma.ingsoftware.eduality.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Topic {


	// PRIMARY KEY
	@Id
	@NotNull
	@GeneratedValue
	private Integer idTopic;


	// OTHER
    private String name;
	private String description;


	// FOREIGN RELATIONS
	@OneToMany (mappedBy = "contentId")
	private List<Content> contentList;
}
