FROM openjdk:16
COPY "./target/backend-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE ${PORT}
ENTRYPOINT [ "java", "-jar", "app.jar" ]