FROM openjdk:11
WORKDIR /app
COPY ./target/restDocker-0.0.1-SNAPSHOT.war /app/
ENTRYPOINT ["java", "-jar", "restDocker-0.0.1-SNAPSHOT.war"]
EXPOSE 8080
