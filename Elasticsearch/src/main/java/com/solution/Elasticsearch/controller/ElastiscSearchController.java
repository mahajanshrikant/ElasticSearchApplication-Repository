package com.solution.Elasticsearch.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solution.Elasticsearch.model.Movie;
import com.solution.Elasticsearch.serviceimpl.ElastisService;
import com.solution.Elasticsearch.serviceimpl.MovieServiceInterface;

@RestController
public class ElastiscSearchController {

private ElastisService service;

@Autowired
MovieServiceInterface movieServiceInterface;

@Autowired
public ElastiscSearchController(ElastisService service) {
	this.service=service;
}

@RequestMapping(value="/getAllmovieData",method=RequestMethod.GET)
public  List<Movie>  getAllMovieData() throws IOException{ 
	List<Movie> result=movieServiceInterface.getallMovieData();
	for(Movie movieloop:result) {
		service.createIndexWithData(movieloop);
	}
	
	return result;		
}

@RequestMapping(value="/searchAllMovie",method=RequestMethod.GET)
public List<Movie> searchAll() throws Exception {

    return service.searchAllMovie();
}



@RequestMapping(value="/searchByQuery",method=RequestMethod.GET)
public List<Movie> searchByQuery(@RequestParam("query") String query ) throws Exception {
	return service.searchByQuery(query);
}


}
