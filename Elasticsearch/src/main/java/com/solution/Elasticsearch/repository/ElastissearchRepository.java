package com.solution.Elasticsearch.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.solution.Elasticsearch.model.Movie;

@Repository
public interface ElastissearchRepository extends JpaRepository<Movie,Integer> {
	

}
