package jsonflattenerfuzzer;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;


import com.github.wnameless.json.flattener.*;

import com.github.wnameless.json.flattener.JsonFlattener;

public class JsonFlattenerFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    String input = data.consumeRemainingAsString();
    System.out.println(input);  
  }
}
