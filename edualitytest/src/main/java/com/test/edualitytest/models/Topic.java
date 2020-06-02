package com.test.edualitytest.models;

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
	
	
	public Topic() {
		super();
	}
	
	
	public Topic(String topicName) {
		name=topicName;
	}
	
	public Integer getIdTopic() {
		return idTopic;
	}




	public void setIdTopic(Integer idTopic) {
		this.idTopic = idTopic;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return name;
	}

	
	
	
	
	
}
