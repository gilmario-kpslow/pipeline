FROM maven:3.6.3-jdk-14 as compile
WORKDIR /usr/src
COPY . /usr/src
RUN mvn clean package -DskipTests

FROM openjdk:14
COPY --from=compile /usr/src/target/spark-helper-pipeline-1.0.0-jar-with-dependencies.jar /usr/src/app.jar
EXPOSE 8080
WORKDIR /usr/src
CMD java -jar -Djava.net.preferIPv4Stack=true /usr/src/app.jar
