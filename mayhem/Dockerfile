FROM gcr.io/oss-fuzz-base/base-builder-jvm
RUN apt-get update && apt-get install -y maven

RUN git clone --depth 1 https://github.com/google/fuzzing && cat fuzzing/dictionaries/json.dict > $SRC/JsonFuzzer.dict

RUN git clone --depth 1 https://github.com/dvyukov/go-fuzz-corpus && zip -q $SRC/JsonFuzzer_seed_corpus.zip go-fuzz-corpus/json/corpus/*

COPY . json-flattener
RUN rm -rf json-flattener/mayhem

COPY mayhem/build.sh $SRC/
COPY mayhem/*.java $SRC/
WORKDIR  $SRC/json-flattener

ENV FUZZING_LANGUAGE=jvm SANITIZER=address FUZZING_ENGINE=libfuzzer
RUN compile
RUN chmod +x /out/jazzer_driver
