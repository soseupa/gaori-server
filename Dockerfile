FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/gaori
EXPOSE 3034
COPY ${JAR_FILE} gaori.jar
ENTRYPOINT ["java", "-jar", "gaori.jar"]