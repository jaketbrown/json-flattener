FROM gcr.io/oss-fuzz-base/base-builder-jvm
RUN apt-get update && apt-get install -y make autoconf automake libtool wget

RUN curl -L https://downloads.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip -o maven.zip && unzip maven.zip -d $SRC/maven && rm -rf maven.zip
ENV MVN $SRC/maven/apache-maven-3.8.6/bin/mvn

COPY . json-flattener
RUN rm -rf json-flattener/mayhem
WORKDIR json-flattener
COPY mayhem/build.sh $SRC/
COPY mayhem/*.java $SRC/

ENV FUZZING_LANGUAGE=jvm SANITIZER=address FUZZING_ENGINE=libfuzzer
RUN compile
RUN chmod +x /out/jazzer_driver
