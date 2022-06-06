FROM openjdk:11
VOLUME /app
ADD /target/e_commerce-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]