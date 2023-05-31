FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/gaori
EXPOSE 3034
COPY build/libs/server-0.0.1.jar kkm.jar
ENTRYPOINT ["java", "-jar", "gaori.jar"]