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
// 		// validate the input, must be correct json
// 		try {
// // 			ObjectMapper mapper = new ObjectMapper();
// // 			mapper.readTree(input);
			
// 			JsonFlattener.flatten(input);
// 			JsonUnflattener.unflatten(input);
// 		} catch (IOException e) {
// 			return;
// 		}
	}
}
