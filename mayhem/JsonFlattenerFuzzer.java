//package jsonflattenerfuzzer;

//import java.util.*;  

//import com.github.wnameless.json.flattener.*;
//import com.github.wnameless.json.base.*;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class JsonFlattenerFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    String input = data.consumeRemainingAsString();
    //Map<String, Object> flattenedJson = new JsonFlattener(input).flattenAsMap();
  }
}
