FROM openjdk:8-jdk-8-jdk-alpine
ARG JAR-FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar","--imageServer=http://{{http://34.212.30.86:8076}}/images/"]