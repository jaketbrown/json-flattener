
import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.unflattener.*;
import java.io.StringReader;
import java.io.IOException;

public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		String input = data.consumeRemainingAsString();
		try {
		JsonFlattener jf;
		JsonUnflattener ju;
		StringReader strReader = new StringReader(input); 


		jf = new JsonFlattener(strReader);
		ju = new JsonUnflattener(strReader);
		} catch (IOException ignored) {

		}
	}
}
