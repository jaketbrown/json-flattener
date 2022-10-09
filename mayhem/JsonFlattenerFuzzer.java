import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.util.*;
import java.lang.NumberFormatException;

import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.base.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.github.wnameless.json.unflattener.*;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonFlattenerFuzzer {
	
//    public static void fuzzerInitialize(){
//    	//Test	
//    	String json = "{ \"a\" : { \"b\" : 1, \"c\": null, \"d\": [false, true] }, \"e\": \"f\", \"g\":2.3 }";
//    	Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(json);
//
//    	System.out.println(flattenJson);
//    }

	public static void fuzzerTestOneInput(FuzzedDataProvider data) throws IOException {

			try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(data.consumeRemainingAsBytes());
			JacksonJsonValue parsedJacksonJsonValue =  new JacksonJsonValue(node);
			
			String nestedJson = JsonUnflattener.unflatten(node.asText());		
			
			Map<String, Object> flattenedJson = new JsonFlattener(node.asText()).flattenAsMap();

			String jsonStr = JsonFlattener.flatten(node.asText());
			
			} catch (JsonProcessingException ignored) {
				
			} catch (NumberFormatException e) {
				
			}

		
	}
}
