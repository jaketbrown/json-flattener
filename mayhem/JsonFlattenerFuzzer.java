import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.util.*;
import java.lang.NumberFormatException;
import java.io.*;
import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.base.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.github.wnameless.json.unflattener.*;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFlattenerFuzzer {


	public static void fuzzerTestOneInput(FuzzedDataProvider data) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
		mapper.enable(JsonParser.Feature.IGNORE_UNDEFINED);
		mapper.enable(JsonParser.Feature.ALLOW_YAML_COMMENTS);
		mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		mapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
		mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);

		try {
			String input = data.consumeRemainingAsString();
			JsonNode node = mapper.readTree(input);

			String nodeText = node.asText();

			JsonFlattener jf = new JsonFlattener(nodeText);
			JsonUnflattener ju = new JsonUnflattener(nodeText);

		} catch (Exception ignored) {

		}

	}
}
