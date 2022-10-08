# Copy seed corpus and dictionary.
mv $SRC/{*.zip,*.dict} $OUT

mvn package -Dmaven.test.skip=true -Djdk.version=15
CURRENT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate \
 -Dexpression=project.version -q -DforceStdout)
cp "target/json-flattener-$CURRENT_VERSION.jar" $OUT/json-flattener.jar

#cp /root/.m2/repository/com/github/wnameless/json/json-base/2.0.0/json-base-2.0.0.jar $OUT/json-base-2.0.0.jar

PROJECT_JARS="json-flattener.jar:/root/.m2/repository/com/github/wnameless/json/json-base/2.0.0/json-base-2.0.0.jar:/root/.m2/repository/org/apache/commons/commons-text/1.9/commons-text-1.9.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.3.1/jackson-core-2.3.1.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.3.1/jackson-databind-2.3.1.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.3.1/jackson-annotations-2.3.1.jar"

# The classpath at build-time includes the project jars in $OUT as well as the
# Jazzer API.
BUILD_CLASSPATH=$(echo $PROJECT_JARS | xargs printf -- "$OUT/%s:"):$JAZZER_API_PATH

# All .jar and .class files lie in the same directory as the fuzzer at runtime.
RUNTIME_CLASSPATH=$(echo $PROJECT_JARS | xargs printf -- "\$this_dir/%s:"):\$this_dir

for fuzzer in $(find $SRC -name '*Fuzzer.java'); do
  fuzzer_basename=$(basename -s .java $fuzzer)
  javac -cp $BUILD_CLASSPATH $fuzzer
  cp $SRC/$fuzzer_basename.class $OUT/

  # Create an execution wrapper that executes Jazzer with the correct arguments.
  echo "#!/bin/sh
# LLVMFuzzerTestOneInput for fuzzer detection.
this_dir=\$(dirname \"\$0\")
LD_LIBRARY_PATH=\"$JVM_LD_LIBRARY_PATH\":\$this_dir \
\$this_dir/jazzer_driver --agent_path=\$this_dir/jazzer_agent_deploy.jar \
--cp=$RUNTIME_CLASSPATH \
--target_class=$fuzzer_basename \
--jvm_args=\"-Xmx2048m\" \
\$@" > $OUT/$fuzzer_basename
  chmod +x $OUT/$fuzzer_basename
done


cat $OUT/$fuzzer_basename
