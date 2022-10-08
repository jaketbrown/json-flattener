import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.util.*;

import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.base.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.github.wnameless.json.unflattener.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) throws IOException {

			String input = data.consumeRemainingAsString();
			try {
				ObjectMapper mapper = new ObjectMapper();
			JacksonJsonValue parsedJacksonJsonValue =  new JacksonJsonValue(mapper.readTree(input));
			
			String nestedJson = JsonUnflattener.unflatten(input);		
			
			Map<String, Object> flattenedJson = new JsonFlattener(input).flattenAsMap();

			String jsonStr = JsonFlattener.flatten(input);
			
			} catch (JsonProcessingException ignored) {
				
			}

		
	}
}
