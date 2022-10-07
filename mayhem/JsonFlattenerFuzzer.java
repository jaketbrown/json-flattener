package jsonflattenerfuzzer;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;


import com.github.wnameless.json.flattener.*;

import com.github.wnameless.json.flattener.JsonFlattener;

public class JsonFlattenerFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    //String json = "{ \"a\" : { \"b\" : 1, \"c\": null, \"d\": [false, true] }, \"e\": \"f\", \"g\":2.3 }";
    String input = data.consumeRemainingAsString();
    Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(json);

    System.out.println(flattenJson);
    
    //System.out.println(input);  
  }
}
