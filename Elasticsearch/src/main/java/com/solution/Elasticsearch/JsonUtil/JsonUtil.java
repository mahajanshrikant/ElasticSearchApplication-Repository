package com.solution.Elasticsearch.JsonUtil;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {
	private static ObjectMapper mapper;
	static {
		mapper=new ObjectMapper();
	}
	
	public String convertjavaobjectTojson(Object object) {
		String jsonResult="";
	try {
		jsonResult =mapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
		System.out.println("Exception occurs while converting java object to Json"+e.getMessage());
	}
	
	return jsonResult;
	}
	
	
	public  <T> T convertJsontoJava(String jsonString,Class<T> cls) {
		T result=null;
		try {
			result=mapper.readValue(jsonString, cls);
		} catch (JsonProcessingException e) {
			System.out.println("Exception occurs while converting Json  to java "+e.getMessage());
		}
		return result;
	}

	
}
