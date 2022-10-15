import com.github.wnameless.json.flattener.*;
import com.github.wnameless.json.unflattener.*;
import java.io.IOException;

public class JsonFlattenerFuzzer {

	public static void fuzzerTestOneInput(byte[] data) {
		String input = new String(data);
		System.out.println(input);
		//try {
			JsonFlattener jf;
			JsonUnflattener ju;

			jf = new JsonFlattener(input);
			String flattened = jf.toString();
			ju = new JsonUnflattener(input);
		//} catch (IOException ignored) {

		//}
	}
}
