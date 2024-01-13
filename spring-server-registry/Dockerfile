FROM openjdk:21
LABEL autor="Jwoliv"
ARG JAR_FILE=target/spring-server-registry-*.jar
COPY ${JAR_FILE} spring-server-registry.jar
ENTRYPOINT ["java", "-jar", "spring-server-registry.jar"]
EXPOSE 9000
