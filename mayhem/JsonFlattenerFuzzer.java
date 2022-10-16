
//import com.github.wnameless.json.flattener.*;
//import com.github.wnameless.json.unflattener.*;
import java.io.StringReader;
import java.io.IOException;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		String input = data.consumeRemainingAsString();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.readTree(input);
		} catch (JacksonException e) {
			return;
		}
		
		System.out.println("====\n" + input);
//		try {
			//StringReader strReader = new StringReader(input);

			JsonFlattener.flatten(input);
			JsonUnflattener.unflatten(input);
//		} catch (Json ignored) {
//
//		}

	}
}
