package es.uma.ingsoftware.eduality.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uma.ingsoftware.eduality.model.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}
