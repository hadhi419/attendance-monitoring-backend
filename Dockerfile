FROM eclipse-temurin:21-jdk

WORKDIR /app

VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dserver.address=0.0.0.0", "-Dserver.port=8080", "-jar", "app.jar"]

