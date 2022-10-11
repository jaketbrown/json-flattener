
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.io.IOException;

import com.github.wnameless.json.flattener.JsonFlattener;


public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		try {
  		String input = data.consumeRemainingAsString();
  		JsonFlattener.flatten(input);

		} catch (IOException ignored) {}
	}
}
