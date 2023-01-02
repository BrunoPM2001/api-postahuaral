FROM openjdk:17-alpine
COPY "./target/postahuaral-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]