import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.util.*;
import java.io.StringReader;
import java.io.IOException;

import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.unflattener.*;
import com.github.wnameless.json.base.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		try {
		String input = data.consumeRemainingAsString();
		JsonFlattener jf;
		JsonUnflattener ju;
		StringReader strReader = new StringReader(input); 
		
		
		jf = new JsonFlattener(strReader);
		ju = new JsonUnflattener(strReader);
		} catch (IOException ignored) {
			
		}
	}
}
