
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.io.IOException;

public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		try {
  		String input = data.consumeRemainingAsString();
  		JsonFlattener.flatten(input);

		} catch (IOException ignored) {}
	}
}
