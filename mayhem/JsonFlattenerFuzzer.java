package jsonflattenerfuzzer;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import json.flattener;

public class JsonFlattenerFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    String input = data.consumeRemainingAsString();
    System.out.println(input);  
  }
}
