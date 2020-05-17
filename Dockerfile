FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-swagger.jar
ENTRYPOINT ["java","-jar","/spring-boot-swagger.jar"]