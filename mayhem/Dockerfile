FROM gcr.io/oss-fuzz-base/base-builder-jvm
RUN apt-get update && apt-get install -y make autoconf automake libtool wget

RUN curl -L https://downloads.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip -o maven.zip && unzip maven.zip -d $SRC/maven && rm -rf maven.zip
ENV MVN $SRC/maven/apache-maven-3.8.6/bin/mvn

RUN git clone --depth 1 https://github.com/google/fuzzing && cat fuzzing/dictionaries/json.dict > $SRC/JsonFuzzer.dict

RUN git clone --depth 1 https://github.com/dvyukov/go-fuzz-corpus && zip -q $SRC/JsonFuzzer_seed_corpus.zip go-fuzz-corpus/json/corpus/*

COPY . json-flattener
RUN rm -rf json-flattener/mayhem
WORKDIR json-flattener
COPY mayhem/build.sh $SRC/
COPY mayhem/*.java $SRC/

ENV FUZZING_LANGUAGE=jvm SANITIZER=address FUZZING_ENGINE=libfuzzer
RUN compile
RUN chmod +x /out/jazzer_driver
