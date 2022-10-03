package jsonflattenerfuzzer;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class JsonFlattenerFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    String input = new String(data);
    System.out.println(input);  
  }
}
