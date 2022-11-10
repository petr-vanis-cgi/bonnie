FROM eclipse-temurin:18-jre
COPY ./starter-1.0-SNAPSHOT.jar /app.jar
CMD ["java", "-jar",  "/app.jar", "--Dspring.profiles.active=devserver"]