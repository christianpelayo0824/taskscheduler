# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME /tmp

# Set the port to expose
EXPOSE 8080

# ARG Variable
ARG JAR_FILE=target/taskscheduler-0.0.1-SNAPSHOT.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} taskscheduler-0.0.1-SNAPSHOT.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","taskscheduler-0.0.1-SNAPSHOT.jar"]




