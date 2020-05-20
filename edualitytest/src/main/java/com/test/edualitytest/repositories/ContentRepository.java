package com.test.edualitytest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.edualitytest.models.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}
