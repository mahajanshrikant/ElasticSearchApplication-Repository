package com.solution.Elasticsearch.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.solution.Elasticsearch.JsonUtil.IndexNamecreation;
import com.solution.Elasticsearch.JsonUtil.JsonUtil;
import com.solution.Elasticsearch.model.Movie;

@Service
public class ElastisService implements ElasticSearchInterface {
	
	private RestHighLevelClient client;

	
	@Autowired
	public ElastisService(RestHighLevelClient client) {
		this.client=client;
	}
	
	

	@Override
	public String createIndexWithData(Movie movie) throws IOException {
		IndexRequest request=new IndexRequest(IndexNamecreation.movieIndex);
		request.id(Integer.toString(movie.getMovieid()));	
		String jsonMovie=new JsonUtil().convertjavaobjectTojson(movie);
		request.source(jsonMovie,XContentType.JSON);
		IndexResponse indexResponse=client.index(request, RequestOptions.DEFAULT);
		System.out.println("response id"+indexResponse.getId());
		return indexResponse.getResult().name();
	}



	@Override
	public List<Movie> searchAllMovie() throws Exception {
		SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse =
                client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(searchResponse);
        
	    }
	
	private List<Movie> getSearchResult(SearchResponse response) {
        List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
        List<Movie> results = new ArrayList<Movie>();
        searchHits.forEach(
        		 hit -> results.add(new JsonUtil().convertJsontoJava(hit.getSourceAsString(), Movie.class)));
        System.out.println(results);
        return results;
	}


 
	@Override
	public List<Movie> searchByQuery(String query) throws Exception {
		SearchRequest searchRequest=new SearchRequest();
		SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
		MatchQueryBuilder matchQueryBuilder=new MatchQueryBuilder("movietitle",query);
		matchQueryBuilder.fuzziness(Fuzziness.AUTO);
		matchQueryBuilder.prefixLength(3);
		matchQueryBuilder.maxExpansions(10);
		searchSourceBuilder.query(matchQueryBuilder);
		SearchResponse response=client.search(searchRequest, RequestOptions.DEFAULT);
		return getSearchResult(response);
	}
	

	
}
