FROM fuzzers/jazzer:0.9.1-openjdk11
RUN apt update && apt install maven -y


COPY . json-flattener
WORKDIR /json-flattener

# Build json-flattener
RUN mvn compile
RUN mv target/json-flattener-0.14.1-SNAPSHOT.jar /json-flattener.jar

# Download dependencies
RUN curl -L https://search.maven.org/remotecontent?filepath=com/github/wnameless/json/json-base/2.0.0/json-base-2.0.0.jar -o json-base-2.0.0.jar
RUN mv json-base-2.0.0.jar /json-base.jar

RUN curl -L https://search.maven.org/remotecontent?filepath=org/apache/commons/commons-text/1.10.0/commons-text-1.10.0.jar -o commons-text-1.10.0.jar
RUN mv commons-text-1.10.0.jar /commons-text.jar

RUN curl -L https://search.maven.org/remotecontent?filepath=org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar -o commons-lang3-3.12.0.jar
RUN mv commons-lang3-3.12.0.jar /commons-lang.jar

RUN curl -L https://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-core/2.14.0-rc2/jackson-core-2.14.0-rc2.jar -o jackson-core.jar
RUN mv jackson-core.jar /

RUN curl -L https://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-databind/2.14.0-rc2/jackson-databind-2.14.0-rc2.jar -o jackson-databind.jar
RUN mv jackson-databind.jar /
RUN curl -L https://search.maven.org/remotecontent?filepath=com/fasterxml/jackson/core/jackson-annotations/2.14.0-rc2/jackson-annotations-2.14.0-rc2.jar -o jackson-annotations.jar
RUN mv jackson-annotations.jar /


# Build the java class
RUN mkdir -p mayhem/build && \
	javac -cp /json-base.jar:/json-flattener.jar mayhem/JsonFlattenerFuzzer.java -d mayhem/build  && \
	cd mayhem/build && \
	jar cvf JsonFlattenerFuzzer.jar * && \
    mv JsonFlattenerFuzzer.jar /JsonFlattenerFuzzer.jar
    
# Set to fuzz!
ENTRYPOINT []
CMD [ "/usr/bin/jazzer_driver", "--cp=/JsonFlattenerFuzzer.jar:/json-base.jar:/json-flattener.jar:/commons-text.jar:/commons-lang.jar:/jackson-core.jar:/jackson-databind.jar:/jackson-annotations.jar", "--target_class=JsonFlattenerFuzzer" ]