FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/gaori
EXPOSE 8080
COPY ./build/libs/gaori-0.0.1-SNAPSHOT.jar gaori.jar
ENTRYPOINT ["java", "-jar", "gaori.jar"]