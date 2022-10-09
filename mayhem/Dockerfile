FROM gcr.io/oss-fuzz-base/base-builder-jvm
RUN curl -L https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip -o maven.zip && unzip maven.zip -d $SRC/maven && rm -rf maven.zip

ENV MVN $SRC/maven/apache-maven-3.6.3/bin/mvn

COPY . json-flattener
RUN rm -rf json-flattener/mayhem

COPY mayhem/testsuite $SRC/json-flattener/testsuite
COPY mayhem/build.sh $SRC/
COPY mayhem/*.java $SRC/
WORKDIR  $SRC/json-flattener

ENV FUZZING_LANGUAGE=jvm SANITIZER=address FUZZING_ENGINE=libfuzzer
RUN compile
RUN chmod +x /out/jazzer_driver
