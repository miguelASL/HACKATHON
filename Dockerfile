FROM openjdk:17-slim

LABEL authors="Miguel Sarmiento"

WORKDIR /hackathon

RUN echo " ¡¡¡ Prueba de la hackathon !!! "

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven && mvn clean install

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/hackathon-0.0.1-SNAPSHOT.jar"]