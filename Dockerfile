FROM openjdk:17.0.2-slim
ARG JAR_FILE=build/libs/webflux-102.jar
COPY ${JAR_FILE} webflux-102.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","webflux-102.jar"]