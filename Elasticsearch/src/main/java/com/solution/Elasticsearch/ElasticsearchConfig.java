package com.solution.Elasticsearch;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ElasticsearchConfig {
	
	@Value("${elasticsearch.host}")
	private String ElasticSearchHost;
	
	@Value("${elasticsearch.port}")
	private int ElasticSearchPort;
	
	
	@Bean(destroyMethod="close") 
	public RestHighLevelClient client() {
		RestClientBuilder builder= RestClient.builder(new HttpHost("localhost",9200))
				.setRequestConfigCallback(
						new RestClientBuilder.RequestConfigCallback() {
					
					@Override
					public Builder customizeRequestConfig(Builder requestConfigBuilder) {
						
						return requestConfigBuilder
								.setConnectTimeout(10000)
					            .setSocketTimeout(60000)
					            .setConnectionRequestTimeout(0);
					            
						
					}
				});
			
		RestHighLevelClient restclient=new RestHighLevelClient(builder);
		return restclient;
	}
	

}
