package com.solution.Elasticsearch.serviceimpl;

import java.io.IOException;
import java.util.List;

import com.solution.Elasticsearch.model.Movie;

public interface ElasticSearchInterface {
	
	public String createIndexWithData(Movie movie) throws IOException;
	
	public List<Movie> searchAllMovie() throws Exception;

	public List<Movie> searchByQuery(String query) throws Exception;
}
