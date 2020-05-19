package com.solution.Elasticsearch.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.Elasticsearch.model.Movie;
import com.solution.Elasticsearch.repository.ElastissearchRepository;

@Service
public class MovieServiceImpl implements MovieServiceInterface {

	@Autowired
	ElastissearchRepository elastissearchRepository;
	
	public List<Movie> getallMovieData(){
		return elastissearchRepository.findAll();
	}
	
	
}
